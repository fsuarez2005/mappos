
package person.franksuarez.MapPOS.common.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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
    
    /** Initializes the SQLite database file.
     * 
     * TODO: SQLiteDatabase.initialize()
     * - [] Check for existing file
     * - [] Create file if not existing
     */
    @Override
    public void initialize() {
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
        
        
    }
    
    
    
    
}
