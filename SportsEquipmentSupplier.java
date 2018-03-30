package sportsequipmentproject;

/**
 * A class to model the management of customer records and purchase orders for 
 * a sports equipment company. 
 * The company distinguishes two categories of customer: sports clubs and 
 * private individuals. 
 * At any time, purchase records for only 12 months, including the current 
 * month, are active.
 * 
 * @author Geoff McKeown
 */
public class SportsEquipmentSupplier {
    
    private Product [] productRange;
    
    private CustomerDetailsList customerRecords;
    private PurchaseOrderList [] purchaseOrderRecords;
                                    // purchase order records are stored by month
    
    private int currentMonth;       // from 1 .. 12
    private int currentYear;        
    
    /**
     * Creates a new instance of SportsEquipmentSupplier
     * @param month         index of the current month (1 .. 12)
     * @param year          the current year
     */
    public SportsEquipmentSupplier(Product [] productList, int month, int year){
        productRange = productList;
        currentMonth = month;
        currentYear = year;
        customerRecords = new CustomerDetailsList();
        purchaseOrderRecords = new PurchaseOrderList [13]; 
                                            // use elements indexed 1 .. 12
                                            // corresponding to the 12 months
        for (int m = 1; m <= 12; m++ )
            purchaseOrderRecords[m] = new PurchaseOrderList();
    }
    
    /**
     * adds the details for a new customer to this supplier's records
     * @param customer 
     */
    public void addNewCustomer( CustomerDetails customer  ){
        customerRecords.addCustomer(customer);
    }
    
    
    
    /**
     * Generates a new purchase order record for the current month 
     * and updates record of purchasing customer
     * @param date          a String with format "dd/mm/yy"
     * @param customerID    must be the ID of a customer in the the company's
     *                      customer records
     * @param p             must be in the company's current product range
     * @param qty           the number of items required of the product
     * @throws IncorrectPurchaseOrderException 
     */
    public void addNewPurchaseOrder
                (String dateStr, String customerID, String productCode, int qty)
                                       throws IncorrectPurchaseOrderException{ 
        try{
            OrderDate date = new OrderDate(dateStr);
            
            int productIndex = FindProductInProductRange(productCode);
            
            if (productIndex == -1 || date.getMonth() != currentMonth 
                                                                || qty <= 0 )                
                throw new IncorrectPurchaseOrderException
                    ("Cannot form a  Purchase Order Record: one or more items "
                    + "of the given data is incorrect.");
            else{
            CustomerDetails customer = customerRecords.findCustomer(customerID);            
            int discount = customer.getDiscount();
            
            //append the purchase order to the list of purchase orders for the
            //current month
            PurchaseOrder poRecord = new PurchaseOrder(date, customerID, 
                                     productRange[productIndex], qty, discount);
            purchaseOrderRecords[currentMonth].addPurchaseOrder(poRecord);
            
            //update the total value of orders made by this customer during 
            // the last year 
            double newTotalAmountOrdered = customer.getTotalValueOfOrders()
                                                + poRecord.getValueOfOrder();
            customer.resetTotalValueOfOrders(newTotalAmountOrdered);                     
            } 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    /** 
     * @return the index of the current month (1 .. 12)
     */
    public int getCurrentMonth(){
        return currentMonth;
    }
    
    /**
     * @return the current year
     */
    public int getCurrentYear(){
        return currentYear;
    }
    
    /**
     * @return  this supplier's product range
     */
    public Product [] getProductRange(){
        return productRange;
    }
    
    /**
     * increments the index of the current month. 12 (December) is followed by 1 
     * (January). Updates this supplier's records as appropriate.
     */
    public void updateMonth(){
        currentMonth ++;
        if ( currentMonth == 13 ){
            currentMonth = 1;
            currentYear++;
        }
       
        // First get an array containing  the purchase records for the month 
        // whose records are to be deleted (if there are any)
        if (purchaseOrderRecords[currentMonth].numberOfPurchaseOrders() > 0){
             
            PurchaseOrder [] oldPurchaseOrders  
                      = purchaseOrderRecords[currentMonth].getPurchaseOrders();
        
            try{
                int n = oldPurchaseOrders.length;
                String customerID;
                CustomerDetails customer;
                for(int i = 0; i < n; i++){
                    customerID = oldPurchaseOrders[i].getCustomerID(); 
                    customer = customerRecords.findCustomer(customerID);
                    // deduct the value of the order placed by this customer a 
                    // year ago from total amount ordered
                    double newAmountOrdered = customer.getTotalValueOfOrders()
                                       - oldPurchaseOrders[i].getValueOfOrder();
                    customer.resetTotalValueOfOrders(newAmountOrdered);
                            
                }
                // Clear the purchase records from a year ago
                purchaseOrderRecords[currentMonth].clearPurchaseOrderList();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    /**
     * @return      the company's current list of customers
     */
    public CustomerDetailsList getCustomerRecords(){
        return customerRecords;
    }
    
    /**
     * @return  the list of this month's purchase orders
     */
    public PurchaseOrderList getPurchaseOrdersForCurrentMonth(){
        return purchaseOrderRecords[currentMonth];
    }
    
    /**
     * @param month     must be in range 1 .. 12
     * @return          list of purchase orders for the specified month
     * @throws InvalidMonthException 
     */
    public PurchaseOrderList getPurchaseOrdersForGivenMonth(int month) 
                                                   throws InvalidMonthException{
        if (month < 1 || month > 12)
            throw new InvalidMonthException("Must have 1 <= month <=12");
        else
            return purchaseOrderRecords[month];
    }
    
    // Search for a given type of product  in the company's current range of 
    // products. If found return the index of the product in productRange.
    // Otherwise return -1
    private int FindProductInProductRange(String productCode){
        
        int n = productRange.length;
        int i = 0; 
        boolean found = false;
        while ( i < n && !found ){
            if (productRange[i].getProductCode().equals(productCode))
                found = true;
            else
                i++;
        }
        if( found ) 
            return i;
        else
            return -1;
    }
}

