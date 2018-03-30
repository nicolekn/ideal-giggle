package sportsequipmentproject;


/**
 * @author Geoff McKeown
 */
public class CustomerNotFoundException extends Exception{
    
    /** Creates an CustomerNotFoundException with a default message */
    public CustomerNotFoundException() {
        super("Given ID does not correspond to any customer.");
    }
}
