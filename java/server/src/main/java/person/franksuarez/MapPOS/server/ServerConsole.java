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
        System.out.println("startTransactionServer()");
        TransactionServer ts = new TransactionServer();
        
        Thread tsThread = new Thread(ts);
        tsThread.start();
        
        // wait for server to complete
        tsThread.join();
    }
    
    public static void startTCPServer() throws InterruptedException {
        System.out.println("startTCPServer()");
        TCPServer server = new TCPServer();
        Thread serverThread = new Thread(server);
        
        serverThread.start();
        
        serverThread.join();
    }
    
    public static void main(String[] args) throws InterruptedException {
        //startTransactionServer();
        //startTCPServer();
        
        //startConsole();

        
    }
}
