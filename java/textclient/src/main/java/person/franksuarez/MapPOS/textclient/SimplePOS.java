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
package person.franksuarez.MapPOS.textclient;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
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
        
        String upcPrompt = "Enter UPC> ";
        String userInput;
        
        
        List<List<String>> transactions = new ArrayList<>();
        
        List<String> currentTransaction = new ArrayList<>();
        //transactions.add(new ArrayList<>());
        
        
        //634418523563
        
        while (true) {
            // currentTransaction is unknown at this point
            
            
            // if in a currentTransaction,
            //      display prompt
            //      collect UPCs
            
            //if (currentTransaction != null) {
            
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
                
                for (String s: currentTransaction) {
                    System.out.printf("item: %s%n",s);
                }
                
                // finish processing transaction
                
                
                
                // append transaction to journal
                
                // start new transaction
                
            } else if (userInput.equals("quit")) {
                break;
                
            } else if (upcPattern.matcher(userInput).find()) {
                System.out.println("UPC found");
                // validate UPC
                UPCA upcaString = new UPCA();
                upcaString.fromString(userInput);
                upcaString.calculateCheckDigit();
                if (upcaString.isValid()) {
                    System.out.println("UPC is valid.");
                }
                if (upcaString.hasValidCheckDigit()) {
                    System.out.println("UPC has valid check digit.");
                }
                
                // if valid, look up upc in database
                
                // if known UPC, enter into transaction
                //transactions.get(currentTransaction).add(userInput);
                currentTransaction.add(userInput);
                
                
            } else {
                System.out.println("Unknown input type!!");

                
            
            }
            
            
        }
        
        
    }
    
    
    
    public static void main(String[] args) throws InvalidFormat {
        SimplePOS p1 = new SimplePOS();
        p1.posTest1();

        
    }
}
