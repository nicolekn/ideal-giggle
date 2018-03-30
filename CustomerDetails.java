package sportsequipmentproject;


/**
 * A class to model a customer of a sports equipment company.
 * The class is abstract because it contains an abstract method to get
 * the percentage discount given to the customer by the company.
 * 
 * @author Geoff McKeown
 */
public abstract class CustomerDetails {
    protected String customerID;    
                // 3 letters, followed by a hyphen, followed by 4 digits. The 
                // first of the 3 letters is a code for the type of customer:
                // 'P' for private individual and 'C' for sports club. 
                // The second and third letters are the code for one of the  
                // company's regions
                                    
    protected Address fullAddress;
    protected String regionalCode;
                // regionalCode must be two characters SC("Scotland"), 
                // WA("Wales"), NI("Northern Ireland"), NE("North East"),  
                // NW("North West"), MI("Midlands"), EA("East Anglia"), 
                // SE("South East"), SW("South West"), GL("Greater London")
    
    protected double totalValueOfOrders;    
                    // Total value of all previous orders during the last 12  
                    // months, including the current month. This total does not
                    // include the value of orders placed more than a year ago.
                                               
    /**
     * Creates a new instance of CustomerDetails
     * @param customerID        unique customer ID
     * @param customerAddress   customer's address
     * @throws sportsequipmentproject.IllegalCustomerIDexception

     */

    public CustomerDetails(String customerID, Address customerAddress) throws IllegalCustomerIDexception{
        if ( isValidCustomerID(customerID) ){
            this.customerID = customerID;
            this.fullAddress = customerAddress;
            this.regionalCode = customerID.substring(1,3);
            this.totalValueOfOrders = 0;
        }
        else
            throw new IllegalCustomerIDexception();        
    }

    
  /**
   * @return the sport equipment company's ID for this customer
   */
    public String getCustomerID(){
        return customerID;
    }
    
    /**
     * @return the full address of this customer
     */
    public Address getAddress(){
        return fullAddress;
    }
    
    /** 
     * @return the code for the region this customer is in.
     */
    public String getRegionalCode(){
        return regionalCode;
    }
    
    /**
     * 
     * @return  Total value of all previous orders during the last 12  
     *          months, including the current month. This total does not
     *          include the value of orders placed more than a year ago.
     */
    public double getTotalValueOfOrders(){
        return totalValueOfOrders;
    }
    
    /**
     * Method to update the total value of orders placed by this customer during 
     * the last 12 months. This needs to be done when the customer places a new 
     * order and when an old order becomes more than 12 months old.
     * @param newAmount     the amount total value is to be changed to
     */
    public void resetTotalValueOfOrders(double newAmount){
        totalValueOfOrders = newAmount;
    }
    
    /**
     * @return this customer's discount
     */
    public abstract int getDiscount();
    
   
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("\n\tCustomer ID:\t");
        str.append(customerID).append("\n\tCustomer address:\t");
        str.append(fullAddress).append("\n\tRegion:\t");
        str.append(regionalCode).append("\n");
        return str.toString();
    }
   
    // checks whether or not a given string has the correct format for a 
    // customer ID string
    private boolean isValidCustomerID(String str){
        if (str.length() != 8)
            return false;
        else{
        // first character must be a valid customer type code ('P' for private
        // individual, 'C' for sports club)
            if (!str.substring(0,1).matches("[P,C]"))
                return false;
            else{// check whether or not next 2 characters correspond to one of 
                 // the company's regional codes
                String  regCode = str.substring(1,3);
                if (!isValidCode(regCode))
                    return false;
                else{
                    return str.substring(3,8).matches("[-]\\d{4}");    
                }
            }
        }
    }
    
    // method to determine whether or not a two character string is a valid
    // regional code of the company
    private boolean isValidCode(String regCode){
        String first = regCode.substring(0,1);
        String second = regCode.substring(1,2);
        return first.matches("[S,s]") && second.matches("[C,c,W,w,E,e]")
                || (first.matches("[N,n]") && second.matches("[I,i,W,w,E,e]"))
                || (first.matches("[W,w,E,e]") && second.matches("[A,a]"))
                || (first.matches("[G,g]") && second.matches("[L,l]"))
                || (first.matches("[M,m]") && second.matches("[I,i]"));     
     }
}
