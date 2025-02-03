/** Very simple Point of Sale.
 * 
 * Used to discover POS process.
 * 
 * Requirements
 * * Create a new transaction
 * * Ask for UPC. Usually entered via barcode scanner.
 * * Append product to transaction.
 * 
 * 
 */
package person.franksuarez.MapPOS.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;
import person.franksuarez.MapPOS.common.model.UPCA;

/**
 *
 * @author franksuarez
 */
public class SimplePOS {
    private static final Logger LOG = Logger.getLogger(SimplePOS.class.getName());
    
    
    
    public void posTest1() throws InvalidFormat {
        // Needed to configure gradle to take stdin. See build.gradle 'run'.
        Scanner sc = new Scanner(System.in);
        
        
        boolean running = true;
        
        // 
        String upcPrompt = "Enter UPC> ";
        String userInput;
        
        
        List<List<String>> transactions = new ArrayList<>();
        
        int currentTransaction = 0;
        transactions.add(new ArrayList<>());
        
        while (running) {
            
            
            
            // create transaction
            
            
            // loop collecting UPCs
            System.out.printf("%s",upcPrompt);
            // Valid input:
            // * UPC
            // * "noupc"
            // * "total"
            // * "quit"
            // * "edit"
            
            try {
                userInput = sc.next();
            } catch (NoSuchElementException e) {
                LOG.severe(e.getMessage());
                break;
            }
            
            
            
            
            System.out.printf("user input: \"%s\"%n",userInput);
            
            // Determine type of input
            Pattern upcPattern = Pattern.compile("\\d{12}");
            
            
            if (userInput.equals("total")) {
                System.out.println("TOTAL");
                
                for (String s: transactions.get(currentTransaction)) {
                    System.out.printf("item: %s%n",s);
                }
                
                
                // start new transaction
                
                
                
            } else if (userInput.equals("quit")){
                System.exit(0);
                
            } else if (upcPattern.matcher(userInput).find()) {
                System.out.println("UPC found");
                // validate UPC
                UPCA upcaString = new UPCA();
                upcaString.fromString(userInput);
                upcaString.calculateCheckDigit();
                if (upcaString.isValid()) {
                    System.out.println("UPC is valid.");
                }
                
                // if valid, look up upc in database
                
                // if known UPC, enter into transaction
                transactions.get(currentTransaction).add(userInput);
                
                
                
            } else {
                System.out.println("Unknown input type!!");
                //transaction.add(userInput);
            
            
            }
            
            
        }
        
        
    }
    
    
    
    public static void main(String[] args) throws InvalidFormat {
        SimplePOS p1 = new SimplePOS();
        p1.posTest1();

        
    }
}
