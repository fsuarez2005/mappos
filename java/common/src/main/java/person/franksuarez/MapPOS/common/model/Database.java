/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author franksuarez
 */
public class Database {
    private Path path;
    private String driver = "sqlite";
    private Connection databaseConnection;
    
    public Database() {}
    
    public Database(String pathStr) {
        this.path = Paths.get(pathStr);

    
    }
    
    public void open() {
        // connection string
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:");
        sb.append(driver);
        sb.append(":");
        sb.append(this.path.toString());
        System.out.printf("%s%n",sb.toString());
        
        try {
            databaseConnection = DriverManager.getConnection(sb.toString());
            if (databaseConnection != null) {
                var meta = databaseConnection.getMetaData();
                
                System.out.printf("Driver name: %s%n",meta.getDriverName());
                
                
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        
        System.out.printf("%s%n",this.databaseConnection.toString());
        
    }
    
    
    // CRUD
    // CREATE
    public void insert() {
        
    }
    
    
    // READ
    // UPDATE
    // DELETE
    
    
}
