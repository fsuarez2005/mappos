/**
 * Console Point of Sale.
 * 
 * DESCRIPTION:
 * 
 * 
 * TODO:
 * - [x] Use ConsolePOS as the command processor and not a terminal emulator
 * - [x] Test ConsolePOS with an SQLite3 database
 * - [] Implement Input/Output properly
 * - [] 
 * 
 * 
 */

package person.franksuarez.MapPOS.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.model.Command;
import person.franksuarez.MapPOS.model.Product;
import person.franksuarez.MapPOS.model.Transaction;
import person.franksuarez.MapPOS.model.UPCA;


/** ConsolePOS interacts with user via terminal.
 *  
 * Purpose:
 * * Read text input from user, interactive or not.
 * * Parse commands.
 * * Interact with retail resources, e.g. transaction database.
 * 
 * @author franksuarez
 */
public class ConsolePOS {
    private enum POSState {
        IDLE, TRANSACTION, UPC
    }
    
    // ----------------------------------------
    private String prompt = "";
    public String getPrompt() {
        this.prompt = this.state.name()+"> ";
        return prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    // ----------------------------------------
    
    private HashMap<String,Command> commands;
    
    private boolean run = true; 
    
    private POSState state;
    
    private BufferedReader reader;
    // ----------------------------------------------------------------------
    
    public ConsolePOS() {}
    

    
    public void initialize() {
        this.state = POSState.IDLE;
        this.commands = new HashMap<>();
        
        
        this.reader = new BufferedReader(new InputStreamReader( System.in ));
    }
    
    public String readLine() {
        String line = "";
        try {
            line = this.reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ConsolePOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }
    
    public void printf(String s, Object... args) {
        System.out.printf(s, args);
    }
    
    
    private void processTransaction() {
        Transaction transaction = new Transaction();
        this.printf("Transaction> ");

        // * Enter UPC of product
        String userInput = this.readLine();
        
        // is userInput a UPC?
        UPCA.isFormattedCorrectly(userInput);
        
        // * Append product to current transaction (only one transaction active)
        Product p = new Product();
        
        transaction.appendProduct(p);
        
        // * Repeat for additional products (allow for duplicate products in transaction)
        // * Sum prices of Products in transaction

        // * Close transaction
        // * Append transaction to journal
        // * Adjust inventory
    }
    
    public void processToken(String token) {
        // check token type
        
        // process token
        switch (token) {
            case "hello" -> {
                this.printf("Hello");
                
            }
            case "quit" -> {
                this.run = false;
            }
            
            
            default -> {}
        }
    }
    
    
    public List<String> tokenize(String source) {
        var output = new ArrayList<String>();
        var scanner = new Scanner(source);
        while (scanner.hasNext()) {
            output.add(scanner.next());
        }
        
        return output;
    }
    
    // TODO: STUB
    private void evaluate(String userInput) {
        
        switch (userInput) {
            case "commands" -> {
                for (String k: this.commands.keySet()) {
                    this.printf("key: %s", k);
                }
            }

            case "normal" -> {
                this.state = POSState.IDLE;
            }
            
            case "transaction" -> {
                this.state = POSState.TRANSACTION;
                processTransaction();
            }
            
            case "quit" -> {
                this.run = false;
            }
            
            case "" -> {}
            
            default -> {
                // print error
                this.printf("ERROR: Command not found\n");

            }
        }
        
    }

    
    
    // TODO: STUB
    private void loop() {
        System.out.println("[loop]");
        while (this.run) {
            // print prompt
            this.printf("%s",this.getPrompt());

            // read input
            String userInput = this.readLine();
            if (userInput == null) {
                // user disconnected or closed input stream
                break;
            }
            
            // evaluate
            this.evaluate(userInput);

            // print
        }
    }
    
    public void start() {
        this.initialize();
        this.loop();
    }
    
    public static void main(String[] args) throws Exception {
        ConsolePOS app = new ConsolePOS();
        
        app.processToken("hello");
    }
}
