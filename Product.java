
package sportsequipmentproject;

/**
 * a class to model a product of the sports equipment company
 * @author Nicole
 */
public class Product {
private String productCode;
private double pricePerUnit;
/**
* create new default product
*/
public Product()
{
    this.productCode=" ";
    this.pricePerUnit=0.0;
}
/**
* create product with given parameters
     * @throws sportsequipmentproject.InvalidProductCodeException
*/
public Product(String productCode, double pricePerUnit) throws InvalidProductCodeException
{
    if(productCode.length()!=6|| !productCode.substring(2,3).equals("/")||!productCode.substring(3).matches("[-+]?\\d*\\.?\\d+")||!productCode.substring(0,2).matches("[a-zA-Z]+"))
    {
        throw new InvalidProductCodeException();
    }
    else
    {
        this.productCode=productCode;
        this.pricePerUnit=pricePerUnit;
    }
}/**
* returns productCode
*/
public String getProductCode()
{
    return this.productCode;
}
/**
* returns unitPrice
*/
public double getUnitPrice()
{
    return this.pricePerUnit;
}
/**
* sets productCode to given value
*/
public void setProductCode(String newProductCode)
{
    this.productCode=newProductCode;
}
/**
* sets unitPrice to given value
*/
public void setUnitPrice(double newUnitPrice)
{
    this.pricePerUnit=newUnitPrice;
}
public String toString()
{
    StringBuilder s =new StringBuilder();
    s.append(" Product Code: ").append(" ").append(productCode).append(" ").append(" Price per Unit: ").append(pricePerUnit);
    return s.toString();
}
}
