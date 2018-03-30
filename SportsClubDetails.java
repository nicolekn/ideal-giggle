
package sportsequipmentproject;

/**
 * A class to store the customer details of sports clubs
 * @author Nicole
 */
public class SportsClubDetails extends CustomerDetails{
    private String clubName;
    private int clubDiscount;
    public SportsClubDetails(String customerID, Address customerAddress, String clubName, int clubDiscount) throws IllegalCustomerIDexception
    {
        super(customerID,customerAddress);  
         this.clubName=clubName;
         this.clubDiscount=clubDiscount;
     }
   @Override
    public int getDiscount(){
        return this.clubDiscount;
    }
    @Override
    public String toString()
    {
        StringBuilder sportDetails= new StringBuilder(super.toString());
        sportDetails.append("Club Name: ").append(clubName).append(" ").append(" Club Discount: ").append(clubDiscount);
        return (sportDetails.toString());
    }
    }

