
package person.franksuarez.MapPOS.client.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.common.model.Message;
import person.franksuarez.MapPOS.common.model.Product;
import person.franksuarez.MapPOS.common.model.Transaction;

/**
 *
 * @author franksuarez
 */
public class TestClient {
    private Socket serverConnection;
    private SocketAddress serverAddress;
    
    
    
    public void shell() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        boolean running = true;
        String prompt = "> ";

        while (running) {
            // print prompt
            System.out.print(prompt);

            // read input
            String userInput = reader.readLine();
            userInput = userInput.stripTrailing();
            Message m = new Message();
            m.messageCommand = Message.Command.DEBUG;
            m.debugString = userInput;
            this.sendMessage(m);
            
            
            //String userInput = console.readLine();
            // print output
            System.out.printf("User input: %s%n", userInput);

        }
    }
    
    
    public void sendTestTransaction() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(this.serverConnection.getOutputStream());
        
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
        
        
        
        
        
        
        
        oos.writeObject(transactionMessage);
        oos.writeObject(newTransaction);
        oos.flush();
        oos.close();
        
        
    }
    
    public void connect() throws IOException {
        this.serverAddress = new InetSocketAddress("localhost",8080);
        this.serverConnection = new Socket();
        this.serverConnection.connect(this.serverAddress);
    }

    public void sendMessage(Message m) {
        try {
            SocketAddress address = new InetSocketAddress("localhost", 8080);
            Socket s = new Socket();
            s.connect(address);

            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            //ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

            //m.messageCommand = Message.Command.VERSION;
            oos.writeObject(m);
            oos.flush();
            oos.close();

            
        } catch (IOException ex) {
            Logger.getLogger(TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        TestClient tc = new TestClient();
        
        tc.connect();
        tc.sendTestTransaction();
        
        
    }
}
