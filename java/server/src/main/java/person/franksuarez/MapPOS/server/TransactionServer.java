/**
 *
 *
 *
 *
 */
package person.franksuarez.MapPOS.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.common.model.Message;

/**
 * Server for collecting completed transactions from POS clients.
 *
 * @author franksuarez
 */
public class TransactionServer implements Runnable {

    ServerSocket listenSocket;
    int port = 8080;
    InetAddress localAddress;
    int backLog = 10;

    public static class ConnectionHandler implements Runnable {

        private Socket request;
        private TransactionServer server;

        // model after RequestHandler
        public ConnectionHandler(Socket request, TransactionServer server) {
            this.request = request;
            this.server = server;
        }

        public void processMessage(Message m) {
            System.out.println("Processing Message");
            
            switch (m.messageCommand) {
                case DEBUG -> {
                    System.out.printf("Client said: %s%n",m.debugString);
                }
                
                default -> {
                    
                }
                
            }
        }

        @Override
        public void run() {
            System.out.println("ConnectionHandler: processing new connection...");


            while (true) {

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(this.request.getOutputStream());

                    // WARNING: should validate any incoming data
                    ObjectInputStream ois = new ObjectInputStream(this.request.getInputStream());

                    // will read until EOFException
                    Message m = (Message) ois.readObject();
                    this.processMessage(m);
                    

                } catch (IOException ex) {
                    // just close socket
                    
                    
                    Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                } catch (ClassNotFoundException ex) {
                    // just close socket
                    
                    Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
            }

        }

    }

    private void configureListenSocket() throws UnknownHostException, IOException {
        // configure listen socket
        this.localAddress = InetAddress.getLocalHost();
        this.listenSocket = new ServerSocket(this.port, this.backLog, this.localAddress);
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

}
