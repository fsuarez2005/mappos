package person.franksuarez.MapPOS.client.ui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.common.model.Message;
import person.franksuarez.MapPOS.common.model.Product;
import person.franksuarez.MapPOS.common.model.Transaction;

/** Text-based POS system.
 *
 * TODO: Extract POS functionality in POS class. This class should only view and control.
 *
 * @author franksuarez
 */
public class TextPOS extends Shell {
    private static final Logger LOG = Logger.getLogger(TextPOS.class.getName());

    private Transaction currentTransaction;

    private final String idlePrompt = "> ";
    private final String transactionPrompt = "TRANSACTION> ";


    private State state = State.IDLE;


    private Socket serverConnection;
    private SocketAddress serverAddress;

    private ObjectOutputStream socketOOS;
    private ObjectInputStream socketOIS;

    
    /** Print status information for debugging reasons.
     * 
     * @throws IOException 
     */
    public void printStatusInfo() throws IOException {
        this.printf("TextPOS%n");

        if (this.serverConnection != null) {
            this.printf("Server is connected: %b%n", this.serverConnection.isConnected());
        }
        if (this.serverAddress != null) {
            this.printf("Server address: %s%n", this.serverAddress);
        }
        if (this.state != null) {
            this.printf("POS state: %s%n", this.state.name());
        }

    }

    /** Connect to server.
     * TODO: Prevent connecting multiple times.
     *
     */
    public void connect() throws IOException {
        // TODO: extract host name and port
        this.serverAddress = new InetSocketAddress("localhost", 8080);
        this.serverConnection = new Socket();
        try {
            this.serverConnection.connect(this.serverAddress);
        } catch (IOException ex) {
            LOG.warning("Cannot connect to server.");
            return;
        }

        this.socketOIS = new ObjectInputStream(this.serverConnection.getInputStream());
        this.socketOOS = new ObjectOutputStream(this.serverConnection.getOutputStream());
    }
    
    
    /** Send Message object to currently connected server.
     * 
     * TODO: check for connection.
     * @param m
     * @throws IOException 
     */
    public void sendMessage(Message m) throws IOException {
        this.socketOOS.writeObject(m);
        this.socketOOS.flush();
    }

    /** Receive Message object from currently connected server.
     * 
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Message recvMessage() throws IOException, ClassNotFoundException {
        Object object = this.socketOIS.readObject();

        Message output = null;

        try {
            output = (Message) object;
        } catch (ClassCastException ex) {
            LOG.severe("Not a message object.");
        }

        return output;
    }

    @Override
    protected void parseLine(String line) throws IOException {
        this.evaluate(line);
    }

    /** Send a Transaction object to server.
     * 
     * @param t
     * @throws IOException 
     */
    public void sendTransaction(Transaction t) throws IOException {
        Message transactionMessage = new Message(Message.Command.TRANSACTION);

        this.socketOOS.writeObject(transactionMessage);
        this.socketOOS.writeObject(t);
        this.socketOOS.flush();

    }

    /** Evaluate user input.
     * 
     * TODO: tokenize input.
     *
     * @param userInput
     */
    private void evaluate(String userInput) throws IOException {

        switch (this.state) {
            case IDLE -> {
                switch (userInput) {
                    case "status" -> {
                        this.printStatusInfo();

                    }

                    case "connect" -> {
                        this.connect();

                    }
                    case "transaction" -> {
                        this.state = State.TRANSACTION;
                        this.setPrompt(this.transactionPrompt);
                        this.currentTransaction = new Transaction();

                    }

                    case "exit" -> {
                        // TODO: stub
                    }
                    default -> {
                        // TODO: stub: report unknow command errors.
                    }
                }
            }
            case TRANSACTION -> {
                // TODO: validate user input
                
                
                switch (userInput) {
                    // TODO: choose standard word to end transaction
                    case "END" -> {
                        
                        this.state = State.IDLE;
                        this.setPrompt(this.idlePrompt);

                        this.sendTransaction(this.currentTransaction);

                        this.currentTransaction = null;

                    }
                    default -> {
                        // if a UPC, append to transaction

                        Product p = new Product();
                        p.setName(userInput);
                        p.setPrice(1.00);

                        this.currentTransaction.addEntry(p);

                    }

                }

            }

        }

    }
    public enum State {
        IDLE,
        TRANSACTION
    }

}
