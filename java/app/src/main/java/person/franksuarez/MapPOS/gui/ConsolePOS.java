/**
 * Console Point of Sale.
 * 
 * DESCRIPTION:
 * 
 * 
 * TODO:
 * - [x] Use ConsolePOS as the command processor and not a terminal emulator
 * - [x] Test ConsolePOS with an SQLite3 database
 * - []
 * 
 * 
 * 
 */




package person.franksuarez.MapPOS.gui;

import java.io.Console;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;



class ProductDatabase {
    private String dbFile = "products.db";
    private Connection conn = null;
    
    public ProductDatabase() {
        
        
    }
    
    public String buildConnectionString(String driver, String location) {
        
        
        return "";
    }
    
    public void connect() {
        
        //Connection conn = null;
        //String connectionString = "jdbc:sqlite:/Users/franksuarez/Desktop/db.sqlite3";
        String connectionString = "jdbc:sqlite:test.db";
        
        
        try {
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Connection has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
    }
    
    public void disconnect() {
        
        
    }
    
    
    
}



/** ConsoleApp interacts with user via terminal.
 *
 * @author franksuarez
 */
public class ConsolePOS {
    private enum POSState {
        IDLE, TRANSACTION, UPC
    }
    
    
    class Command {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        // -----------------------------------
        private Consumer<String> commandCode;

        public Command(String name, Consumer<String> commandCode) {
            this.name = name;
            this.commandCode = commandCode;
        }


        // -----------------------------------
        public void apply(String arg) {
            this.commandCode.accept(arg);
        }
        
    }
    
    private String prompt = "";

    public String getPrompt() {
        this.prompt = this.state.name()+"> ";
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    private HashMap<String,Command> commands;
    
    private boolean run = true; 
    
    private POSState state;
    
    public Console cons;

    // ----------------------------------------------------------------------
    
    public ConsolePOS() {}
    

    
    public void initialize() {
        this.state = POSState.IDLE;
        this.cons = System.console();
        this.commands = new HashMap<>();
    }
    
    public String readLine() {
        String line = cons.readLine();
        return line;
    }
    
    public void printf(String s, Object... args) {
        cons.printf(s,args);
    }

    // TODO: STUB
    private void evaluate(String userInput) {
        System.out.println("[evaluate]");
        if (this.commands.containsKey(userInput)) {
            System.out.println("Found command");
            this.commands.get(userInput).apply(userInput);
            return;
        }
        
        
        
        switch (userInput) {
            case "commands" -> {
                for (String k: this.commands.keySet()) {
                    this.printf("key: %s", k);
                }
            }
            case "products" -> {
                ProductDatabase db = new ProductDatabase();
                db.connect();
                
                
            }

            case "normal" -> {
                this.state = POSState.IDLE;
            }
            
            case "transaction" -> {
                this.state = POSState.TRANSACTION;
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

    private void testaddCommands() {

        
        this.commands.put("hello", new Command("hello", (s) -> {
            this.printf("hello");
        }));
        
        
        
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
        this.loop();
    }
    
    public static void main(String[] args) throws Exception {
        ConsolePOS app = new ConsolePOS();
        
        app.initialize();
        
        app.testaddCommands();
        
        app.start();        
    }
}
