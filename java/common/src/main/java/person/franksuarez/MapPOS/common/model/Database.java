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
    protected Path path;
    protected String driver = "sqlite";
    protected Connection databaseConnection;
    
    public Database() {}
    
    public Database(String pathStr) {
        this.path = Paths.get(pathStr);

    
    }
    
    public void setPath(Path path) {
        this.path = path;
    }
    
    public Path getPath() {
        return this.path;
    }
    
    public String getConnectionString() {
        return "jdbc:"+this.driver+":"+this.path.toAbsolutePath().toString();
        
        
    }
    
    
    public void open() throws Exception {
        if (this.path == null) {
            throw new Exception("Database path not set.");
        }
        String connectionString = this.getConnectionString();
        
        
        try {
            databaseConnection = DriverManager.getConnection(connectionString);
            if (databaseConnection != null) {
                var meta = databaseConnection.getMetaData();
                
                System.out.printf("Driver name: %s%n",meta.getDriverName());
                
                System.out.printf("%s%n",this.databaseConnection.toString());
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        
        
        
    }
    
    
    // CRUD
    // CREATE
    
    
    
    // READ
    // UPDATE
    // DELETE
    
    
}
