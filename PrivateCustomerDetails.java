package sportsequipmentproject;

import java.text.NumberFormat;

/**
 * A class to model a private individual customer of a sports equipment
 * company
 * @author Geoff McKeown
 */
public class PrivateCustomerDetails extends CustomerDetails{
    
    private static final float TOTAL_FOR_MAX_DISCOUNT = 500;
                            // Min that totalValueOfOrders must be for customer  
                            // to get the max discount rate on further purchases 
                            // during the current twelve months.
                     
    
    private static final int MAX_DISCOUNT = 15;
                                // maximum percentage discount
    
    // Fields specific to this type of customer
    private Name fullName;
    
    
     /**
     * Creates a new instance of PrivateCustomerDetails
     * @param customerID        unique customer ID
     * @param customerAddress   customer's address 
     * @param customerName      private customer's name
     * 
     * @throws IllegalCustomerIDexception   if the customerID String does 
     *                                  not have the required format
     */
    public PrivateCustomerDetails 
                 (String customerID, Address customerAddress, Name customerName) 
                                              throws IllegalCustomerIDexception{
        super(customerID, customerAddress);
        if ( customerID.charAt(0) != 'P')
            throw new IllegalCustomerIDexception("Customer ID must begin with 'P'"
                    + " for a private individual customer");
        else
            fullName = customerName;
    }
    
    /**
     * 
     * @return  customer's full name
     */
    public Name getCustomerName(){
        return fullName;
    }         
    
    @Override
    public int getDiscount(){
        if ( totalValueOfOrders >= TOTAL_FOR_MAX_DISCOUNT )
            return MAX_DISCOUNT;
        else if (totalValueOfOrders > 0){
            double proportionalDiscount = 
                    totalValueOfOrders * MAX_DISCOUNT / TOTAL_FOR_MAX_DISCOUNT;
            return (int) proportionalDiscount;
        }
        else
            return 0;
    }
    
    @Override
    public String toString(){
        NumberFormat fmt = NumberFormat.getPercentInstance();
        
        StringBuilder str = new StringBuilder(super.toString());
        str.append(fullName).append("\n\tCurrent discount: ").append(getDiscount());
        return str.toString();
    }
}
