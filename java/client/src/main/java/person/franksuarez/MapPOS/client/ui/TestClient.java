/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author franksuarez
 */
public class TestClient {

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
        tc.shell();
    }
}
