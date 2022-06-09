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
public class CustomerDAO implements DAO<Customer>
{   
    public CustomerDAO() {
        
    }
    List<Customer> customers;
    /**
     * Get a single contact entity as a contact object
     * @param id
     * @return 
     */
    @Override
    public Optional<Customer> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Customer WHERE Customer_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Customer customer = null;
            while (rs.next()) {
                customer = new Customer(rs.getInt("Customer_ID"), rs.getString("Customer_First_Name"), rs.getString("Customer_Last_Name"),rs.getString("Customer_Street_Address"), rs.getString("Customer_City"), rs.getInt("Customer_Zip_Code"), rs.getString("Customer_State"), rs.getString("Customer_Phone_Number"));
            }
            return Optional.ofNullable(customer);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all customer entities as a List
     * @return 
     */
    @Override
    public List<Customer> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Customer";
            rs = db.executeQuery(sql);
            Customer customer = null;
            while (rs.next()) {
                customer = new Customer(rs.getInt("Customer_ID"), rs.getString("Customer_First_Name"), rs.getString("Customer_Last_Name"),rs.getString("Customer_Street_Address"), rs.getString("Customer_City"), rs.getInt("Customer_Zip_Code"), rs.getString("Customer_State"), rs.getString("Customer_Phone_Number"));
                customers.add(customer);
            }
            return customers;
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
    public void insert(Customer customer)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Customer(Customer_ID, Customer_First_Name, Customer_Last_Name, Customer_Street_Address, Customer_City, Customer_Zip_Code, Customer_State, Customer_Phone_Number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, customer.getcustomerID());
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.setString(4, customer.getStreetAddress());
            stmt.setString(5, customer.getCity());
            stmt.setInt(6, customer.getZipCode());
            stmt.setString(7, customer.getState());
            stmt.setString(8, customer.getPhoneNumber());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new customer was inserted successfully!");
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
    public void update(Customer customer) {
        DB db = DB.getInstance();
        try {
            //Customer_ID, Customer_First_Name, Customer_Last_Name, Customer_Street_Address, Customer_City, Customer_Zip_Code, Customer_State, Customer_Phone_Number
            String sql = "UPDATE Customer SET Customer_First_Name=?, Customer_Last_Name=?, Customer_Street_Address=?, Customer_City=?, Customer_Zip_Code=?, Customer_State=?, Customer_Phone_Number=? WHERE Customer_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getStreetAddress());
            stmt.setString(4, customer.getCity());
            stmt.setInt(5, customer.getZipCode());
            stmt.setString(6, customer.getState());
            stmt.setString(7, customer.getPhoneNumber());
            stmt.setInt(8, customer.getcustomerID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Customer was updated successfully!");
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
    public void delete(Customer customer) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Customer WHERE Customer_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, customer.getcustomerID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Customer was deleted successfully!");
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
            String sql = "SELECT * FROM Customer WHERE Customer_ID = -1";//We just need this sql query to get the column headers
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
