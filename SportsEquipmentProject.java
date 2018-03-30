
package sportsequipmentproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.PrintWriter;
/**
 * class to test SportsEquipmentProject
 * @author Nicole Nieves
 */
public class SportsEquipmentProject {

    /**
     * @throws java.io.FileNotFoundException
     * @throws sportsequipmentproject.InvalidProductCodeException
     * @throws sportsequipmentproject.IllegalCustomerIDexception
     * @throws sportsequipmentproject.IllegalDateFormatException
     * @throws sportsequipmentproject.IncorrectPurchaseOrderException
     * @throws sportsequipmentproject.CustomerNotFoundException
     */
    public static void productRange() throws FileNotFoundException,InvalidProductCodeException,IllegalCustomerIDexception, IllegalDateFormatException, IncorrectPurchaseOrderException, CustomerNotFoundException
    {
        Scanner fileScan; 

        int numberOfProducts=0;

        try{
            fileScan= new Scanner( new File("productData.txt"));
            numberOfProducts= fileScan.nextInt();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        //System.out.println(numberOfProducts);
        Scanner codes = new Scanner (new File("productData.txt")).useDelimiter("#");
        Product [] productRange=new Product[numberOfProducts];
        String[] productCodes=new String[numberOfProducts];
        Double [] prices=new Double[numberOfProducts];
        codes.nextLine();//skip one line
        for (int i = 0; i<numberOfProducts;i++)
        {
            productCodes[i]=codes.next();
            //System.out.println(productCodes[i]);
        }
        Scanner price = new Scanner (new File("productData.txt")).useDelimiter("#");
        price.nextLine();price.nextLine();//skip first 2 lines
        for(int i=0;i<numberOfProducts;i++)
        {
            prices[i]=price.nextDouble();
            //System.out.println(prices[i]);
        }
        for(int i=0;i<numberOfProducts;i++)
        {
            productRange[i]=new Product(productCodes[i],prices[i]);
        }
        //Create a SportsEquipmentSupplier with this product range
        SportsEquipmentSupplier supplier= new SportsEquipmentSupplier(productRange,1,2013);
        Scanner customers = new Scanner (new File("CustomerData.txt")).useDelimiter("/");
        while(customers.hasNext())
        {
            String customerID=customers.next().trim();
            /*System.out.print(customerID);
            System.out.println();*/
            switch (customerID.charAt(0)) {
                case 'P':
                    String title=customers.next();
                    //System.out.println(title);
                    String initials=customers.next();
                    //System.out.println(initials);
                    String surname = customers.next();
                    //System.out.println(surname);
                    Name customerName= new Name(title,initials,surname);
                    String street=customers.next();
                    //System.out.println(street);
                    String city=customers.next();
                    //System.out.println(city);
                    String postcode=customers.next();
                    //System.out.println(postcode);
                    Address address= new Address(street,city,postcode);
                    PrivateCustomerDetails privateCustomer = new PrivateCustomerDetails(customerID, address,customerName);
                    supplier.addNewCustomer(privateCustomer);
                    break;
                case 'C':
                    String clubName=customers.next();
                    String clubStreet=customers.next();
                    String clubCity=customers.next();
                    String clubPostcode=customers.next();
                    Address clubAddress= new Address(clubStreet,clubCity,clubPostcode);
                    String discount =customers.next();
                    SportsClubDetails sportsClub= new SportsClubDetails(customerID,clubAddress,clubName,Integer.parseInt(discount));
                    supplier.addNewCustomer(sportsClub);
                    break;
                default:
                    System.out.println(customerID);
                    break;
            }
        }
        CustomerDetailsList list=supplier.getCustomerRecords();
        Scanner purchaseOrders = new Scanner( new File("PurchaseOrderData.txt")).useDelimiter("#");
        while(purchaseOrders.hasNext())
        {
            String date=purchaseOrders.next();
            String cID=purchaseOrders.next();
            String productCode=purchaseOrders.next();
            int quantity=purchaseOrders.nextInt();
            supplier.addNewPurchaseOrder(date,cID,productCode,quantity);
            if(cID.charAt(0)=='P')
            {
                System.out.println(cID+" "+list.findCustomer(cID));
            }
            
        }
    }
    public static void main(String[] args) throws FileNotFoundException,InvalidProductCodeException,IllegalCustomerIDexception,IllegalDateFormatException, IncorrectPurchaseOrderException, CustomerNotFoundException{
    /*OrderDate date;
        try {
            date = new OrderDate("21/03/17");
            System.out.println(date.getMonth());
        } catch (IllegalDateFormatException ex) {
            Logger.getLogger(SportsEquipmentProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
    
    productRange();
    }
}
