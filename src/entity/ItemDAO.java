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
public class ItemDAO implements DAO<Item>
{   
    public ItemDAO() {
        
    }
    List<Item> items;
    /**
     * Get a single contact entity as a contact object
     * @param id
     * @return 
     */
    @Override
    public Optional<Item> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Item WHERE Item_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Item item = null;
            while (rs.next()) {
                item = new Item(rs.getInt("Item_ID"), rs.getString("Item_Name"), rs.getInt("Item_Price"), rs.getInt("Item_UPC_Code"));
            }
            return Optional.ofNullable(item);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all contact entities as a List
     * @return 
     */
    @Override
    public List<Item> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        items = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Item";
            rs = db.executeQuery(sql);
            Item item = null;
            while (rs.next()) {
                item = new Item(rs.getInt("Item_ID"), rs.getString("Item_Name"), rs.getInt("Item_Price"), rs.getInt("Item_UPC_Code"));
                items.add(item);
            }
            return items;
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
    public void insert(Item item)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Item(Item_ID, Item_Name, Item_Price, Item_UPC_Code) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, item.getItemID());                                                                   ///// i am doing this pat and on 24 min mark of the video
            stmt.setString(2, item.getItemName());
            stmt.setInt(3, item.getPrice());
            stmt.setInt(4, item.getUPC());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new Item was inserted successfully!");
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
    public void update(Item item) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Item SET Item_Name=?, Item_Price=?, Item_UPC_Code=? WHERE Item_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, item.getItemName());
            stmt.setInt(2, item.getPrice());
            stmt.setInt(3, item.getUPC());
            stmt.setInt(4, item.getItemID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Item was updated successfully!");
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
    public void delete(Item item) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Item WHERE Item_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, item.getItemID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Iem was deleted successfully!");
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
            String sql = "SELECT * FROM Item WHERE Item_ID = -1";//We just need this sql query to get the column headers
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
