/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author franksuarez
 */
public class MessageServerConnection {
    private ObjectOutputStream socketOOS;
    private ObjectInputStream socketOIS;

    public MessageServerConnection() {}
    
    
    public void connect() {}
    
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
            System.out.println("Not a message object.");
        }
        return output;
    }
    
    
}
