
package sportsequipmentproject;

/**
 *Class to model the address of a customer
 * with a street, city, and postcode
 * @author Nicole
 */
public class Address {
private String street;
private String city;
private String postcode;
/**
* Creates a new Address
*/

public Address()
{
    this.street=" ";
    this.city=" ";
    this.postcode=" ";

}
/**
* Creates a new Address
*/
public Address(String street, String city, String postcode)
{
    this.street=street;
    this.city=city;
    this.postcode=postcode;

}

public String toString()
{
    StringBuilder address= new StringBuilder();
    address.append(street).append(" ").append(city).append(" ").append(postcode);
    return address.toString();
}
}
