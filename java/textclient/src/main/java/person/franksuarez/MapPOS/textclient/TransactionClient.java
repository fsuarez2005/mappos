/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.textclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import person.franksuarez.MapPOS.common.model.Message;
import person.franksuarez.MapPOS.common.model.Product;
import person.franksuarez.MapPOS.common.model.Transaction;
import person.franksuarez.MapPOS.common.model.TransactionMessage;

/** Connects to TransactionServer and tests.
 *
 * @author franksuarez
 */
public class TransactionClient {
    private String serverAddress;
    private int serverPort;
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private SocketAddress addr;
    
    
    public void configureSocket() throws IOException {
        this.clientSocket = new Socket();
        this.clientSocket.setReuseAddress(true);
        
    }
    
    public void connect() throws IOException {
        this.clientSocket.connect(this.addr);
        
        this.out = new ObjectOutputStream(this.clientSocket.getOutputStream());
        this.in = new ObjectInputStream(this.clientSocket.getInputStream());
    }
    
    
    public void testTransactionMessage() throws IOException {
        configureSocket();
        this.serverAddress = "localhost";
        this.serverPort = 8080;
        this.addr = new InetSocketAddress(this.serverAddress, this.serverPort);
        
        this.connect();
        
        
        Product pepsi = new Product();
        pepsi.setName("Pepsi");
        pepsi.setCost(2.00);
        
        
        Transaction t = new Transaction();
        t.addEntry(pepsi);
        
        
        
        TransactionMessage m = new TransactionMessage();
        m.content = t;
        m.messageCommand = Message.Command.TRANSACTION;
        
        this.out.writeObject(m);
        
        
        
        
        
        
    }
    
    
    public void tests1() throws IOException, ClassNotFoundException {
        configureSocket();
        SocketAddress addr = new InetSocketAddress("localhost", 8080);
        clientSocket.connect(addr);
        
        OutputStream outos = clientSocket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outos);
        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        
        
        
        Message m = new Message(Message.Command.INQUIRY);
        
        //m.debugString = "hello there";
        oos.writeObject(m);
        Message newMessage = (Message) ois.readObject();
        System.out.printf("Message: %s%n",newMessage.toString());
        
        
        System.out.println("test1()");
        
        clientSocket.close();
    }
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("TransactionClient");
        TransactionClient client = new TransactionClient();
        client.testTransactionMessage();
        
        
    }
    
}
