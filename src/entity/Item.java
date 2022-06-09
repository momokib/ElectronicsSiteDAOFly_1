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
public class Item 
{
    private int itemID;
    private String itemName;
    private int price;
    private int UPC;
    
    public Item(int itemID, String itemName, int price, int UPC)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.UPC = UPC;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getUPC() {
        return UPC;
    }

    @Override
    public String toString() {
        return "Item{" + "ID=" + itemID + ", itemName=" + itemName + ", price=" + price + ", UPC=" + UPC + '}';
    }
}
