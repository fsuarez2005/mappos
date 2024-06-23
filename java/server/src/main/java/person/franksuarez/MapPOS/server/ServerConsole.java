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
    public static void startTransactionServer() throws InterruptedException {
        TransactionServer ts = new TransactionServer();
        
        Thread tsThread = new Thread(ts);
        tsThread.start();
        
        
        // wait for server to complete
        tsThread.join();
        
    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
        startTransactionServer();

        
        
        
    }
    
}
