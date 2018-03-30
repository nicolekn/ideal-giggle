/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsequipmentproject;

/**
 *
 * @author Nicole
 */
public class InvalidProductCodeException extends Exception {
/**
* Creates a new InvalidProductCodeException with default message
*/
    public InvalidProductCodeException() {
        super("Product code not valid.");
    } 
}
