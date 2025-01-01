/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Basic TCP Server
 *
 * @author franksuarez
 */
public class TCPServer implements Runnable {
    private ServerSocket listenSocket;
    private int port;
    private int backlog;
    private InetAddress localAddress;

    private void configureListenSocket() throws UnknownHostException, IOException {
        // configure listen socket
        this.localAddress = InetAddress.getLocalHost();
        this.listenSocket = new ServerSocket(this.port, this.backlog, this.localAddress);
        this.listenSocket.setReuseAddress(true);

    }

    @Override
    public void run() {
        System.out.println("Starting TransactionServer...");

        try {
            this.configureListenSocket();
        } catch (IOException ex) {
            Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        // TODO: should listen for signals
        while (true) {
            Socket conn = null;
            try {
                conn = this.listenSocket.accept();
            } catch (IOException ex) {
                Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
            }

            ConnectionHandler handler = new ConnectionHandler(conn, this);
            Thread connThread = new Thread(handler);
            connThread.start();

        }

    }

    
        public static class ConnectionHandler implements Runnable {
        private final Socket request;
        private final TCPServer server;

        // model after RequestHandler
        public ConnectionHandler(Socket request, TCPServer server) {
            this.request = request;
            this.server = server;
        }

        @Override
        public void run() {
            
        }

    }
}
