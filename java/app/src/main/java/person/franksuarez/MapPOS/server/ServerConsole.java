/**
 * 
 * 
 * 
 * 
 * 
 */
package person.franksuarez.MapPOS.server;

/**
 *
 * @author franksuarez
 */
public class ServerConsole {
    
    
    
    
    public static void main(String[] args) throws InterruptedException {
        TransactionServer ts = new TransactionServer();
        
        
        Thread tsThread = new Thread(ts);
        
        
        tsThread.join();
        
        
        
        
        
    }
    
}
