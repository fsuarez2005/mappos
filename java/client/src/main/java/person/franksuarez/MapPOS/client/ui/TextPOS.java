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

/**
 *
 * TODO: Fix
 *
 * @author franksuarez
 */
public class TextPOS extends Shell {

    
    
    
    private static final Logger LOG = Logger.getLogger(TextPOS.class.getName());

    private Socket serverConnection;
    private SocketAddress serverAddress;

    private ObjectOutputStream socketOOS;
    private ObjectInputStream socketOIS;

    public TextPOS() {
        System.out.println("TextPOS");
    }

    /**
     * Connect to server.
     *
     *
     */
    public void connect() throws IOException {
        // TODO: extract host name and port
        this.serverAddress = new InetSocketAddress("localhost", 8080);
        this.serverConnection = new Socket();
        this.serverConnection.connect(this.serverAddress);

        this.socketOIS = new ObjectInputStream(this.serverConnection.getInputStream());
        this.socketOOS = new ObjectOutputStream(this.serverConnection.getOutputStream());
    }

    public void sendMessage(Message m) throws IOException {
        this.socketOOS.writeObject(m);
        this.socketOOS.flush();
    }

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

    private void processTransaction() {
    }

    public void sendTestTransaction() throws IOException  {

        Message transactionMessage = new Message(Message.Command.TRANSACTION);

        // create test transaction
        Transaction newTransaction = new Transaction();
        Product p1 = new Product();
        p1.setName("Pepsi");
        p1.setPrice(2.00);
        newTransaction.addEntry(p1);

        Product p2 = new Product();
        p2.setName("Mountain Dew");
        p2.setPrice(2.00);
        newTransaction.addEntry(p2);

        this.socketOOS.writeObject(transactionMessage);
        this.socketOOS.writeObject(newTransaction);
        this.socketOOS.flush();


    }

    /**
     * TODO: migrate to evaluateToken
     *
     * @param userInput
     */
    private void evaluate(String userInput) throws IOException {

        switch (userInput) {
            case "hello" -> {
                this.printf("hello");
            }
            
            case "connect" -> {
                this.printf("Connecting to server...");
                this.connect();
                
            }
            case "transaction" -> {
                this.sendTestTransaction();
                
            }
            default -> {

            }
        }

    }

}
