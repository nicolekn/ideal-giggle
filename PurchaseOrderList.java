package sportsequipmentproject;

import java.util.ArrayList;

/**
 * a class to model a list of PurchaseOrder objects
 * @author Nicole
 */
public class PurchaseOrderList {
private ArrayList<PurchaseOrder> purchaseOrderList;
/**
* Creates new PurchaseOrderList
*/
public PurchaseOrderList()
{
    purchaseOrderList=new ArrayList<PurchaseOrder>(); 
}
/**
* adds a PurchaseOrder to the purchaseOrderList
*/
public void addPurchaseOrder(PurchaseOrder newPurchaseOrder)
{
    purchaseOrderList.add(newPurchaseOrder);
}
/**
* empties the purchaseOrderList
*/
public void clearPurchaseOrderList()
{
    purchaseOrderList.clear(); 
}
/**
* returns an array with all the items in the purchaseOrderList
*/
public PurchaseOrder [] getPurchaseOrders()
{
    if(purchaseOrderList.isEmpty())
    {
        return null;
    }
    else
    {
    return purchaseOrderList.toArray(new PurchaseOrder[purchaseOrderList.size()]);
    }
}
/**
* returns the number of items in the purchaseOrderList
*/
public int numberOfPurchaseOrders()
{
    return purchaseOrderList.size();
}
}
