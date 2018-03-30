
package sportsequipmentproject;

/**
 *class to model the date a product was ordered
 * models date as a string
 * @author Nicole
 */
public class OrderDate {
private String date;
    /**
* Creates a new OrderDate
* @param date must have the format "dd/mm/yy" otherwise
* @throws IllegalDateFormatException
*/
public OrderDate(String date) throws IllegalDateFormatException
{
    if(date.length()==8&&date.substring(2,3).equals("/")&&date.substring(5,6).equals("/"))
    this.date=date;
    else
        throw new IllegalDateFormatException();
        
}
/**
* gets month as an integer from the date string
*/
public int getMonth()
{
    return Integer.parseInt(date.substring(3,5));
}
public String toString()
{
    return this.date;
}
}
