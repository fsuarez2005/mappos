
package person.franksuarez.MapPOS.common.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franksuarez
 */
public class SQLiteDatabase extends Database {
    private static final Logger LOG = Logger.getLogger(SQLiteDatabase.class.getName());
    
    
    public SQLiteDatabase() {
        super();
        this.driver = "sqlite";
    }
    
    public SQLiteDatabase(Path path) {
        super("sqlite", path);
    }
    
    
    /** Removes DB file.
     * 
     */
    public void deleteDBFile() throws IOException, Exception {
        if (this.path == null) {
            throw new Exception("Path is null.");
        }
        File f = this.path.toFile();
        
        
        if (this.path.toFile().exists()) {
            System.out.printf("File: %s%n",f.toString());
            Files.deleteIfExists(this.path);
        }
    }
    
    @Override
    public String buildConnectionString() {
        return "jdbc:" + this.driver + ":" + this.path.toString();
    }
    

    @Override
    public void open() {
        if (this.path == null) {
            // should throw exception
            //throw new Exception("Database path not set.");
            
            
            return;
            
        }
        
        String connectionString = this.buildConnectionString();
        LOG.info(String.format("Connection String: %s%n",connectionString));
        
        
        try {
            databaseConnection = DriverManager.getConnection(connectionString);
            if (databaseConnection != null) {
                var meta = databaseConnection.getMetaData();
                LOG.info(String.format("Driver name: %s%n", meta.getDriverName()));
                LOG.info(String.format("%s%n", this.databaseConnection.toString()));

            }
        } catch (SQLException e) {
            LOG.severe(e.getMessage());
        }
    }
    
    /** Initializes the SQLite database file.
     * 
     * TODO: SQLiteDatabase.initialize()
     * - [] Check for existing file
     * - [] Create file if not existing
     */
    @Override
    public void initialize() {
        if (this.initialized) {
            return;
        }
        
        
        File dbFile = this.path.toFile();
        System.out.printf("File: %s%n",dbFile.getAbsolutePath());
        
       
        if ( this.path != null ) {
            LOG.info("path is not null");
            if (! dbFile.isFile()) {
                LOG.info("path is not file. creating.");
                try {
                    dbFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        this.initialized = true;
        
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
