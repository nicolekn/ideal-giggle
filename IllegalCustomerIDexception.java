
package sportsequipmentproject;

/**
 *
 * @author Nicole
 */
public class IllegalCustomerIDexception extends Exception {
/**
* Creates a new IllegalCustomerIDException with default message
*/
    public IllegalCustomerIDexception () {
        super("Given ID does not correspond to any customer.");
    }
/**
* Creates a new IllegalCustomerIDException with given message
*/
    public IllegalCustomerIDexception(String message)
    {
        super(message);
    }
}
