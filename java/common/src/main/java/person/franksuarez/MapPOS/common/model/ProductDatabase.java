// TODO: header

/**
 * TASKS:
 * TODO: create standard database methods
 * TODO: create Database interface
 * 
 * 
 * 
 */
package person.franksuarez.MapPOS.common.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ProductDatabase {
    private String dbFile = "products.db";
    private Connection conn = null;
    private String driverString = "sqlite";
    private String productTableName = "products";
    
    public String getDriverString() {
        return this.driverString;
    }
    
    public ProductDatabase setDriverString(String driverString) {
        this.driverString = driverString;
        return this;
    }

    public String getDbFile() {
        return dbFile;
    }

    public ProductDatabase setDbFile(String dbFile) {
        this.dbFile = dbFile;
        return this;
    }

    public String getProductTableName() {
        return productTableName;
    }

    public ProductDatabase setProductTableName(String productTableName) {
        this.productTableName = productTableName;
        return this;
    }
    
    
    
    public ProductDatabase() {
    }
    
    public String buildConnectionString(String location) {
        return "jdbc:"+driverString+":"+location;
    }
    
    public void connect(String location) throws SQLException {
        this.conn = DriverManager.getConnection(buildConnectionString(location));
    }
    
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    
    
    public void printConnectionInfo() {
        try {
            System.out.printf("Connection: %s%n",
                    conn.getClientInfo()
            );
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void initializeDatabase() throws SQLException {
        this.conn.setAutoCommit(true);
        
        System.out.println("Dropping "+this.productTableName+" table");
        String dropTableString = String.format("DROP TABLE IF EXISTS %s", this.productTableName);
        boolean hasDropped = this.conn.createStatement().execute(dropTableString);
        if (hasDropped) {
            System.out.println("Table Dropped");
        }

        System.out.println("Creating "+this.productTableName+" table.");
        // create tables
        PreparedStatement createTablePS = this.conn.prepareStatement(
                "CREATE TABLE "+this.productTableName+" ( id INTEGER )"
        );
        createTablePS.execute();
    }
    
    
    
    
    // CRUD
    // create
    public void create(Product p) {}
    
    // read
    public void read(int key) {}
    
    // update
    public void update(int key) {}
    
    // delete
    public void delete(int key) {}
    
    public void testConnection() {
        
        //Connection conn = null;
        //String connectionString = "jdbc:sqlite:/Users/franksuarez/Desktop/db.sqlite3";
        //String connectionString = "jdbc:sqlite:test.db";
        
        
        String connectionString = buildConnectionString("test.db");
        
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

    
    
    
    
}

