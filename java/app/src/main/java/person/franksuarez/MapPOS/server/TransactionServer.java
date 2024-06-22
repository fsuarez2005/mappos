/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Thread.sleep;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Server for collecting completed transactions from POS clients.
 *
 * @author franksuarez
 */
public class TransactionServer implements Runnable {
    ServerSocket listenSocket;
    int port = 8080;
    InetAddress localAddress;
    int backLog = 10;

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static class ConnectionHandler implements Runnable {
        private Socket request;
        private TransactionServer server;
        
        // model after RequestHandler
        public ConnectionHandler(Socket request, TransactionServer server) {
            this.request = request;
            this.server = server;
        }

        @Override
        public void run() {
            BufferedOutputStream out;
            BufferedInputStream in;
            
            try {
                out = new BufferedOutputStream(this.request.getOutputStream());
                in = new BufferedInputStream(this.request.getInputStream());
                
                
                out.write("Hello there\n".getBytes());
                out.flush();
                this.request.close();
            } catch (IOException ex) {
                Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            
        }
        
    }
    
    
    private void configureListenSocket() throws UnknownHostException, IOException {
        // configure listen socket
        this.localAddress = InetAddress.getLocalHost();
        this.listenSocket = new ServerSocket(this.port,this.backLog,this.localAddress);
        this.listenSocket.setReuseAddress(true);
        
        
        
    }
    
    
    public void start() throws IOException {
        try {
            this.configureListenSocket();
        } catch (IOException ex) {
            Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        // TODO: should listen for signals
        while (true) {
            Socket conn = this.listenSocket.accept();
            
            ConnectionHandler handler = new ConnectionHandler(conn, this);
            Thread connThread = new Thread(handler);
            connThread.start();
            
            
            
            
        }
        
        
        
        
    }
    
    
}
