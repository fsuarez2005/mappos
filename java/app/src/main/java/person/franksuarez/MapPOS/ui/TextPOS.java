/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.ui;

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

/**
 * 
 * TODO: Fix
 *
 * @author franksuarez
 */
public class TextPOS {
    
    private String prompt = "";

    private HashMap<String, Command> commands;

    private boolean run = true;

    private POSState state;

    private BufferedReader reader;

    public TextPOS() {
    }

    public String getPrompt() {
        this.prompt = this.state.name() + "> ";
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    // ----------------------------------------

    public void initialize() {
        this.state = POSState.IDLE;
        //this.commands = new HashMap<>();
        createCommands();

        this.reader = new BufferedReader(new InputStreamReader(System.in));

    }

    /**
     * Reads a line from standard input.
     *
     * @return
     */
    public String readLine() {
        String line = "";
        try {
            line = this.reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TextPOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    /**
     * Sends a formatted string with arguments to standard out.
     *
     * @param s
     * @param args
     */
    public void printf(String s, Object... args) {
        System.out.printf(s, args);
    }

    private void processTransaction() {
        Transaction transaction = new Transaction();
        this.printf("Transaction> ");

        // * Enter UPC of product
        String userInput = this.readLine();

        // is userInput a UPC?
        UPCA u = new UPCA();

        u.fromString(userInput);

        //UPCA.isFormattedCorrectlyStatic(userInput);
        // * Append product to current transaction (only one transaction active)
        Product p = new Product();

        transaction.addEntry(p);

        // * Repeat for additional products (allow for duplicate products in transaction)
        // * Sum prices of Products in transaction
        // * Close transaction
        // * Append transaction to journal
        // * Adjust inventory
    }

    /**
     * Splits a string line into multiple tokens.
     *
     * @param source
     * @return
     */
    public List<String> tokenize(String source) {
        var output = new ArrayList<String>();
        var scanner = new Scanner(source);
        while (scanner.hasNext()) {
            output.add(scanner.next());
        }
        return output;
    }

    /**
     * TODO: migrate to evaluateToken
     *
     * @param userInput
     */
    private void evaluate(String userInput) {

        switch (userInput) {
            case "commands" -> {
                for (String k : this.commands.keySet()) {
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

            case "" -> {
            }

            default -> {
                // print error
                this.printf("ERROR: Command not found\n");

            }
        }

    }

    public void evaluateToken(String token) {
        // get command
        if (this.commands.containsKey(token)) {
            this.commands.get(token).accept(token);
        } else {
            this.printf("Command not found: %s%n", token);
        }
    }

    private void loop() {
        System.out.println("[loop]");
        while (this.run) {
            // print prompt
            this.printf("%s", this.getPrompt());

            // read input
            String userInput = this.readLine();
            if (userInput == null) {
                // user disconnected or closed input stream
                break;
            }

            // evaluate
            //this.evaluate(userInput);
            this.evaluateToken(userInput);

            // print
        }
    }

    public void createCommands() {
        this.commands = new HashMap<>();
        this.commands.put("about", new Command("about", (x) -> {
            this.printf("About ConsolePOS%n"
                    + "fsuarez2007@gmail.com%n"
                    + "");
        }).setShortDescription("Display about information"));

        this.commands.put("quit", new Command("quit", (x) -> {
            this.run = false;
        }));

        this.commands.put("idle", new Command("idle", (x) -> {
            this.state = POSState.IDLE;
        }));

        this.commands.put("transaction", new Command("transaction", (t) -> {
            this.state = POSState.TRANSACTION;

        }));

        this.commands.put("commands", new Command("commands", (t) -> {
            this.printf("Commands:%n");
            for (String name : this.commands.keySet()) {
                this.printf("%s:\t\t%s%n", name, this.commands.get(name).getShortDescription());
            }
        }));

    }

    public void start() {
        this.initialize();
        this.loop();
    }

    class Token {
        // TODO: stub: Token
    }

    private enum POSState {
        IDLE, TRANSACTION, UPC
    }
}
