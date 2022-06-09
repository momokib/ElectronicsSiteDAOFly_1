/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *
 * @author Gokhan
 */
public class OrdersDAO implements DAO<Orders>
{   
    public OrdersDAO() {
        
    }
    List<Orders> orders;
    /**
     * Get a single order entity as a order object
     * @param id
     * @return 
     */
    @Override
    public Optional<Orders> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Orders WHERE Order_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Orders ordeRs = null;
            while (rs.next()) {
                ordeRs = new Orders(rs.getInt("Order_ID"), rs.getInt("Order_Quantity"), rs.getString("Order_Date_TIME"), rs.getInt("Customer_ID"), rs.getInt("Item_ID"));
            }
            return Optional.ofNullable(ordeRs);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all order entities as a List
     * @return 
     */
    @Override
    public List<Orders> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Orders";
            rs = db.executeQuery(sql);
            Orders ordeRs = null;
            while (rs.next()) {
                ordeRs = new Orders(rs.getInt("Order_ID"), rs.getInt("Order_Quantity"), rs.getString("Order_Date_TIME"), rs.getInt("Customer_ID"), rs.getInt("Item_ID"));
                orders.add(ordeRs);
            }
            return orders;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a contact object into contact table
     * @param contact 
     */
    @Override
    public void insert(Orders ordeRs)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Orders(Order_ID, Order_Quantity, Order_Date_TIME, Customer_ID, Item_ID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, ordeRs.getOrderID());
            stmt.setInt(2, ordeRs.getQuantity());
            stmt.setString(3, ordeRs.getDateTime());
            stmt.setInt(4, ordeRs.getCustomer_ID());
            stmt.setInt(5, ordeRs.getItem_ID());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new order was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a contact entity in database if it exists using a contact object
     * @param contact
     */
    @Override
    public void update(Orders ordeRs) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Orders SET Order_Quantity=?, Order_Date_TIME=?, Customer_ID=?, Item_ID=? WHERE Order_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, ordeRs.getQuantity());
            stmt.setString(2, ordeRs.getDateTime());
            stmt.setInt(3, ordeRs.getCustomer_ID());
            stmt.setInt(4, ordeRs.getItem_ID());
            stmt.setInt(5, ordeRs.getOrderID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing contact was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a contact from contact table if the entity exists
     * @param contact 
     */
    @Override
    public void delete(Orders ordeRs) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Orders WHERE Order_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, ordeRs.getOrderID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A contact was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Orders WHERE Order_ID = -1";//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }
}
