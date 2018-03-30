/*
*class to model a list of CustomerDetails objects

 */

package sportsequipmentproject;
import java.util.ArrayList;

/**
 *
 * @author Nicole
 */
public class CustomerDetailsList {
private ArrayList<CustomerDetails> customerList;
/**
* Creates a new CustomerDetailsList
*/
public CustomerDetailsList()
{
    customerList=new ArrayList<CustomerDetails>();
}
/**
* adds a CustomerDetails object to a CustomerDetailsList
*/
public void addCustomer(CustomerDetails newCustomer)
{
    customerList.add(newCustomer);
}
/**
* returns the number of objects in the CustomerDetailsList
*/
public int customerListSize()
{
    return customerList.size();
}
/**
*
* @param givenID the ID of a customer
* @return the customer’s details if found,
* exception thrown otherwise.
*/
public CustomerDetails findCustomer(String givenID)throws CustomerNotFoundException
{
    int index=-1;
    for(int i = 0;i<customerList.size();i++)
    {
        if(givenID.equals(customerList.get(i).getCustomerID()))
        {
           index=i;
           break;
        }
        
    }
    if(index!=-1)
    {
        return customerList.get(index);
    }
    else
    {
        throw new CustomerNotFoundException();
    }
}
public String toString()
{
    StringBuilder s = new StringBuilder();
for(int i = 0;i<customerList.size();i++)
    {
        s.append(customerList.get(i).toString()).append("/n");
    }
return s.toString();
}
}
