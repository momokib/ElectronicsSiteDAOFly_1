/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;
import entity.*;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Gokhan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static DAO customerDAO;
    private static DAO itemDAO;
    private static DAO ordersDAO;
    
    public static void main(String[] args) {
        customerDAO = new CustomerDAO();
        //(customerID, firstName, lastName, streetAddress, city, zipCode, state, phoneNumber)
       /*** addCustomer(4, "BIll", "Fore", "989 West Lake PK", "Landmore", 12334, "PA", "+1-216-551-6776");
        addCustomer(5, "Sezen", "King", "345 North Bake RD", "WestMore", 12345, "GA", "+1-216-567-7654");
        addCustomer(44, "Frank", "Nui", "234 south stake LN", "Frankvil", 43132, "BA", "+1-216-456-4567");
        addCustomer(2, "Rick", "Stand", "432 east Lake DR", "Landmore", 32143, "NY", "+1-216-234-4323");
        //addCustomer(4, "BIll", "Fore", "989 West Lake PK", "Landmore", 12334, "PA", "+1-216-551-6776");
        printCustomers();
        itemDAO = new ItemDAO();
        //addItem(int itemID, String itemName, int price, int UPC)
        addItem(24,"Laptop", 250, 876598217);
        addItem(34,"Phone", 440, 987600065);
        addItem(54,"Tablet", 500, 834565550);
      
        printItems(); ***/
        
        ordersDAO = new OrdersDAO();
        //addOrders(int orderID, int quantity, String dateTime, int Customer_ID, int Item_ID)
       
        addOrders(7, 1,"2022-03-28 22:02:26.682", 65,14);

        
        printOrders();
        /*** Contact contact;
        contact = new Contact(1, "John", "Doe", "+1-215-551-6776");
        customerDAO.update(contact);//Update John
        * 
        * ORDERS PART
       addOrders(2, 1,"2022-03-29 22:02:26.682", 4,24);
        addOrders(3, 1,"2022-03-28 22:02:26.682", 44,54);
        addOrders(4, 2,"2022-03-27 21:02:26.682", 2,34);
        
        contact = new Contact(2, "Alice", "Mira", "+1-215-334-4343");
        customerDAO.insert(contact);//Insert Alice
        contact = new Contact(2, "Alice", "Smith", "+1-215-334-4343");
        customerDAO.update(contact); 
     
        contact = new Contact(3, "Sezen", "Aksu", "+90-535-331-4869");
        customerDAO.insert(contact);//Insert Sezen
        printContacts();
        customerDAO.delete(contact);//Delete Sezen
        contact = new Contact(4, "Mike", "Smith", "+1-216-551-6776");
        customerDAO.delete(contact);
        printContacts();
        contact = getContact(0);
        System.out.println(contact.getID() + "-" + contact.getFirstName() + "-" + contact.getLastName() + "-" + contact.getPhoneNumber());***/
    }
    
    static void addCustomer(int customerID, String firstName, String lastName, String streetAddress, String city, int zipCode, String state,String phoneNumber) {
        Customer customer;
        customer = new Customer(customerID, firstName, lastName, streetAddress, city, zipCode, state, phoneNumber);
        customerDAO.insert(customer);
    }
    
     static void addItem(int itemID, String itemName, int price, int UPC) {
        Item item;
        item = new Item(itemID, itemName, price, UPC);
        itemDAO.insert(item);
    }
     
     static void addOrders(int orderID, int quantity, String dateTime, int Customer_ID, int Item_ID) {
        Orders orders;
        orders = new Orders(orderID, quantity, dateTime, Customer_ID,Item_ID);
        ordersDAO.insert(orders);
    }
    
    static Customer getCustomer(int id) {
        Optional<Customer> customer = customerDAO.get(id);
        return customer.orElseGet(() -> new Customer(-1, "Non-exist", "Non-exist", "Non-exist", "Non-exist", -1, "Non-exist", "Non-exist"));
    }
    
      static Item getItem(int id) {
        Optional<Item> item = itemDAO.get(id);
        return item.orElseGet(() -> new Item(-1, "Non-exist", -1, -1));
    }
    
    
    static void printCustomers() {
        List<String> headers = customerDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%26s", header);
        }
        System.out.println();
        //Print the results
        List<Customer> customer = customerDAO.getAll();
        int numberRows = customer.size();
        for (int i = 0; i < numberRows; i++) {                                                                                                                                                                                                             
            System.out.printf("%26s%26s%26s%26s%26s%26s%26s%26s", customer.get(i).getcustomerID(), customer.get(i).getFirstName(), customer.get(i).getLastName(), customer.get(i).getStreetAddress(), customer.get(i).getCity(), customer.get(i).getZipCode(), customer.get(i).getState(), customer.get(i).getPhoneNumber());
            System.out.println();
        }
        
    }
     static void printItems() {
        List<String> headers = itemDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%17s", header);
        }
        System.out.println();
        //Print the results
        List<Item> item = itemDAO.getAll();
        int numberRows = item.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%17s%17s%17s%17s", item.get(i).getItemID(), item.get(i).getItemName(), item.get(i).getPrice(), item.get(i).getUPC());
            System.out.println();
        }
        
    }
     
      static void printOrders() {
        List<String> headers = ordersDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%17s", header);
        }
        System.out.println();
        //Print the results
        List<Orders> orders = ordersDAO.getAll();
        int numberRows = orders.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%17s%17s%17s%17s%17s", orders.get(i).getOrderID(), orders.get(i).getQuantity(), orders.get(i).getDateTime(), orders.get(i).getCustomer_ID(), orders.get(i).getItem_ID());
            System.out.println();
        }
        
    }
     
}
