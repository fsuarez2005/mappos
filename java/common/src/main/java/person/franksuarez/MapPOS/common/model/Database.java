// TODO: header
package person.franksuarez.MapPOS.common.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;

/**
 *
 * @author franksuarez
 */
public class Database {
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

    public String getConnectionString() {
        return "jdbc:" + this.driver + ":" + this.path.toAbsolutePath().toString();
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
                LOG.info(String.format("Driver name: %s%n", meta.getDriverName()));
                LOG.info(String.format("%s%n", this.databaseConnection.toString()));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    public void initialize() {};

    // CRUD
    
    
    
    // CREATE
    // READ
    // UPDATE
    // DELETE
}
