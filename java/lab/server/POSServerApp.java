// TODO: List
// [] Server thread
// [] Console thread


import java.net.*;
import java.io.*;

/** Console reads commands from STDIN and processes them.
 */
class Console implements Runnable {
    public void processInput(String userInput) {
        
        
        
    }
    
    
    public void run() {
        BufferedInputStream bis = new BufferedInputStream(System.in);
        
        System.out.println("Console run");
        boolean running = true;
        /*
        while (running) {
            // print prompt
            
            // get input
            
            // process input
            
            
            
            
            
        }
        */
        
        
    }
}

class Server {}




public class POSServerApp {
    public String banner = "-- POSServerApp --";
    
    
    public void test1() {
        try {
            ServerSocket s = new ServerSocket();
            s.setReuseAddress(true);
            s.bind(new InetSocketAddress(2000));
            
            s.accept();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
    
    public static void main(String[]  args) {
        
        
        POSServerApp p = new POSServerApp();
        System.out.println(p.banner);
        
        
        // start console thread
        Console c = new Console();
        Thread consoleThread = new Thread(c); 
        
        System.out.printf("Daemon: %b%n",consoleThread.isDaemon());
        
        
        consoleThread.start();
        
        
        
        
    }
}