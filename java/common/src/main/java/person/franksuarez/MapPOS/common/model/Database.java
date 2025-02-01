// TODO: header
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

    public Database() {}

    public Database(String driver, Path path) {
        this.driver = driver;
        this.path = path;
    }

    
    
    public void setPath(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return this.path;
    }
    
    public Connection getConnection() {
        return this.databaseConnection;
    }

    public abstract String buildConnectionString();


    
    public abstract void initialize();

    // CRUD
    
    
    
    // CREATE
    // READ
    // UPDATE
    // DELETE
}
