/**
 * 
 * 
 */
package person.franksuarez.MapPOS.server;

import java.io.Console;

/**
 * 
 * @author franksuarez
 */
public class ServerConsole {
    public static void startConsole() {
        System.out.println("startConsole()");
        
        // determine if System Console is available
        Console cons = System.console();
        if (cons == null) {
            System.out.println("No console found!");
        } else { 
            
            
        }
        
        boolean running = true;
        while (running) {
            running = false;
        }
        
        
    }
    
    public static void startTransactionServer() throws InterruptedException {
        TransactionServer ts = new TransactionServer();
        
        Thread tsThread = new Thread(ts);
        tsThread.start();
        
        // wait for server to complete
        tsThread.join();
    }
    
    public static void main(String[] args) throws InterruptedException {
        //startTransactionServer();
        
        
        startConsole();
        
        
    }
}
