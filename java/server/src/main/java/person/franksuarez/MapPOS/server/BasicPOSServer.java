/**
 *
 * Cashier process:
 * * greet customer
 * *
 *
 *
 *
 *
 */
package person.franksuarez.MapPOS.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import person.franksuarez.MapPOS.common.model.POS;

/**
 *
 * @author franksuarez
 */
public class BasicPOSServer {

    private person.franksuarez.MapPOS.common.model.POS pos;
    private BufferedReader reader;

    public BasicPOSServer() {
        this.pos = new POS();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        BasicPOSServer app = new BasicPOSServer();

        app.processTransaction();
    }

    public String readLine() throws IOException {
        return this.reader.readLine();
    }

    public void processTransaction() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        // Create new transaction
        ArrayList<String> currentTransaction = new ArrayList<String>();

        // greet customer
        System.out.println("Hello");

        System.out.println("Did you find the products that you wanted?");

        // does customer have any products
        System.out.println("Are there any products that you would like to buy?");

        userInput = reader.readLine();

        boolean hasProducts = !userInput.equals("exit");;

        while (hasProducts) {
            System.out.println("Enter UPC (exit to complete transaction): ");
            // for each product scan UPC
            userInput = reader.readLine();

            System.out.printf("userInput: %s%n", userInput);

            if (userInput.equals("exit")) {
                break;
            }

            // Validate UPC
            // Display information about product based on UPC
            System.out.println("=== Product ===");
            System.out.printf("Name: %s%n", userInput);
            System.out.println("Price: $0.00%n");

            // Append product to current transaction
            currentTransaction.add(userInput);

        } // hasProducts

        System.out.println("Current Transaction:");

        for (int n = 0; n < currentTransaction.size(); n++) {
            System.out.printf("Product: %s%n", currentTransaction.get(n));

        }

    }

}
