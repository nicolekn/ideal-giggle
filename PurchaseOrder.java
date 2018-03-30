package sportsequipmentproject;

import java.text.NumberFormat;

/**
 * A class to model a purchase order record for a sports equipment company
 * @author Geoff McKeown
 */
public class PurchaseOrder {
     
    private OrderDate dateOrderPlaced; // format dd/mm/yy
    private String customerID;
    
    private Product productType;    
    private int quantityOrdered;
    
    private int customerDiscount;
    
    /**
     * creates a new purchase order record
     * @param orderDate     
     * @param customerID
     * @param pType
     * @param quantityOrdered
     * @param customerDiscount 
     */
    public PurchaseOrder(OrderDate orderDate, String customerID, Product pType, 
                                  int quantityOrdered, int customerDiscount){
            this.dateOrderPlaced = orderDate;
            this.customerID = customerID;
            this.productType = pType;
            this.quantityOrdered = quantityOrdered;
            this.customerDiscount = customerDiscount;
    }
    
    /**
     * @return the date the purchase order was placed
     */
    public OrderDate getDateOfOrder(){
        return dateOrderPlaced;
    }
    
    /**
     * @return the id of the customer placing the purchase order
     */
    public String getCustomerID(){
        return customerID;
    }
    
    /**
     * @return the product the purchase order is for
     */
    public Product getProductType(){
        return productType;
    }
    
    /**
     * @return the value of the purchase order
     */
    public double getValueOfOrder(){
        return quantityOrdered * productType.getUnitPrice();
    }
    
    /**
     * @return the amount of the invoice after taking any discount into account
     */
    public double getInvoiceAmount(){
        return (1 - (double) customerDiscount/100 ) 
                                * quantityOrdered * productType.getUnitPrice();
    }
       
    @Override
    public String toString(){
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        StringBuilder str = new StringBuilder("\tDate of order: ");
        str.append(dateOrderPlaced).append("\n\tCustomerID: ");
        str.append(customerID).append("\n").append(productType);
        str.append("\n\tQuantity ordered: ").append(quantityOrdered);
        str.append("\n\tValue of Order: ").append(fmt.format(getValueOfOrder()));
        str.append("\n\tAmount of customer Invoice: ");
        str.append(fmt.format(getInvoiceAmount()));
        str.append("\n---------------------------------------------\n");
        return str.toString();
    }
}
