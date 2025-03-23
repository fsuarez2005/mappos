// TODO: header

package person.franksuarez.MapPOS.common.model;

/**
 *
 * @author franksuarez
 */
public abstract class JournalDatabase extends Database {
    
    
    /** Inserts Transaction into database.
     * 
     * @param t 
     */
    public void insert(Transaction t) throws Exception {
        if (this.databaseConnection == null) {
            throw new Exception("Database is null.");
        }
        
        
        
        
    }
    
    
    
}
