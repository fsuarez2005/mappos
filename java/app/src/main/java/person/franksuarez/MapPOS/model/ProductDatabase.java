/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ProductDatabase {
    private String dbFile = "products.db";
    private Connection conn = null;
    
    public ProductDatabase() {
        
        
    }
    
    public String buildConnectionString(String driver, String location) {
        
        
        return "";
    }
    
    public void connect() {
        
        //Connection conn = null;
        //String connectionString = "jdbc:sqlite:/Users/franksuarez/Desktop/db.sqlite3";
        String connectionString = "jdbc:sqlite:test.db";
        
        
        try {
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Connection has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    }
    
    public void disconnect() {
        
        
    }
    
    
    
}

