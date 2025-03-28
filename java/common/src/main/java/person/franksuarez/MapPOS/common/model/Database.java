/**
 * 
 * Notes:
 * https://en.wikipedia.org/wiki/ACID
 * https://en.wikipedia.org/wiki/Create,_read,_update_and_delete
 * 
 * 
 */
package person.franksuarez.MapPOS.common.model;

import java.nio.file.Path;
import java.sql.Connection;
import java.util.logging.Logger;

/**
 *
 * @author franksuarez
 */
public abstract class Database {
    private static final Logger LOG = Logger.getLogger(Database.class.getName());

    protected Path path;
    protected String driver;
    
    protected Connection databaseConnection;
    
    protected boolean initialized = false;
    

    public Database() {}

    public Database(String driver, Path path) {
        this.driver = driver;
        this.path = path;
    }

    public abstract String buildConnectionString();
    public abstract void initialize();
    public abstract void open();
    public abstract void close();
    
    
    
    // CRUD
    
    
    
    // CREATE
    // READ
    // UPDATE
    // DELETE
}
