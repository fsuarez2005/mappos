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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author franksuarez
 */
public class SimplePOS {
    public void posTest1() {
        // Needed to configure gradle to take stdin. See build.gradle 'run'.
        Scanner sc = new Scanner(System.in);
        
        
        boolean running = true;
        String prompt = "Enter UPC> ";
        String userInput = "";
        List<String> transaction = new ArrayList();
        
        
        while (running) {
            // create transaction
            
            
            // loop collecting UPCs
            System.out.printf("%s",prompt);
        
            if (sc.hasNextLine()) {
                userInput = sc.nextLine();
            } else {
                running = false;
            }
            
            System.out.printf("user input: %s%n",userInput);
            
            // Determine type of input
            
            // done. complete transaction
            Pattern donePattern = Pattern.compile("^done$");
            Matcher doneMatcher = donePattern.matcher(userInput);
            if (doneMatcher.find()) {
                // exit loop
                System.out.println("DONE");
                running = false;
                
                for (String x: transaction) {
                    System.out.printf("item: %s%n",x);
                }
                
            } else {
            
                transaction.add(userInput);
            
            
            }
            
            
        }
        
        
    }
    
    
    
    public static void main(String[] args) throws IOException {
        SimplePOS p1 = new SimplePOS();
        p1.posTest1();

        
    }
}
