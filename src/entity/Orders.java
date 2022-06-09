/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 */
public class Orders 
{
    private int orderID;
    private int quantity;
    private String dateTime;
    private int Customer_ID;
    private int Item_ID;
    
    public Orders(int orderID, int quantity, String dateTime, int Customer_ID, int Item_ID)
    {
        this.orderID = orderID;
        this.quantity = quantity;
        this.dateTime = dateTime;
        this.Customer_ID = Customer_ID;
        this.Item_ID = Item_ID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public int getItem_ID() {
        return Item_ID;
    }


    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID + ", quantity=" + quantity + ", dateTime=" + dateTime + ", Customer_ID=" + Customer_ID + ", Item_ID=" + Item_ID + '}';
    }
}
