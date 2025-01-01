/**
 *
 *
 *
 *
 */
package person.franksuarez.MapPOS.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.common.model.Message;
import person.franksuarez.MapPOS.common.model.Product;
import person.franksuarez.MapPOS.common.model.Transaction;

/** Server for collecting completed transactions from POS clients.
 *
 * @author franksuarez
 */
public class TransactionServer implements Runnable {

    ServerSocket listenSocket;
    int port = 8080;
    InetAddress localAddress;
    int backLog = 10;

    /**
     * 
     * 
     */
    public static class ConnectionHandler implements Runnable {
        private final Socket request;
        private final TransactionServer server;

        private ObjectOutputStream requestOOS;
        private ObjectInputStream requestOIS;

        // model after RequestHandler
        public ConnectionHandler(Socket request, TransactionServer server) {
            this.request = request;
            this.server = server;
        }

        /** Reads object from socket and deserialize.
         *
         * @return
         * @throws java.io.IOException
         * @throws java.lang.ClassNotFoundException
         */
        public Object readObject() throws IOException, ClassNotFoundException {
            Object output = this.requestOIS.readObject();

            return output;
        }

        public void writeObject(Object o) throws IOException {
            this.requestOOS.writeObject(o);
        }

        private void setUpObjectReaderWriter() throws IOException {
            this.requestOOS = new ObjectOutputStream(this.request.getOutputStream());
            this.requestOIS = new ObjectInputStream(this.request.getInputStream());
        }

        public void processMessage(Message m) throws IOException, ClassNotFoundException {
            System.out.println("Processing Message");

            switch (m.messageCommand) {
                case DEBUG -> {
                    System.out.printf("Client said: %s%n", m.debugString);
                }
                case INQUIRY -> {
                    // send message with response to inquiry
                    
                    
                    
                }
                case TRANSACTION -> {
                    // read object from stream
                    // should be a Transaction
                    Transaction t = (Transaction) this.readObject();
                    System.out.println("Received transaction");
                    
                    System.out.println("Products:");
                    for (Product p: t.getEntries()) {
                        System.out.printf("Item: %s%n",p.getName());
                    }
                    
                    System.out.printf("Subtotal: %f%n",t.getSubTotal());

                    // process transaction
                }

                default -> {

                }

            }
        }

        @Override
        public void run() {
            try {
                this.setUpObjectReaderWriter();

                System.out.println("ConnectionHandler: processing new connection...");
                boolean running = true;

                while (running) {

                    // get object from stream
                    // assume object is message
                    Message m = (Message) this.readObject();
                    this.processMessage(m);

                }

            } catch (IOException ex) {
                if (ex instanceof java.io.EOFException) {
                    
                } else if (ex instanceof java.net.SocketException) {
                    
                } else {
                    Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TransactionServer.class.getName()).log(Level.SEVERE, null, ex);
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
