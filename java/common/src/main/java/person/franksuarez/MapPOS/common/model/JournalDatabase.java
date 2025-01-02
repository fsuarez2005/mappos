/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

/**
 *
 * @author franksuarez
 */
public class JournalDatabase extends Database {
    
    
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
