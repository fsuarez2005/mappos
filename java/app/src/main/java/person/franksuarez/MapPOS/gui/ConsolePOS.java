/**
 * Console Point of Sale.
 * 
 * DESCRIPTION:
 * 
 * 
 * TODO:
 * - [] Use ConsolePOS as the command processor and not a terminal emulator
 * - [] Test ConsolePOS with an SQLite3 database
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
    enum POSState {
        IDLE, TRANSACTION, UPC
    }
    
    
    class Command {
        
    }
    
    private String prompt = "> ";
    
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

            case "quit" -> {
                this.run = false;
            }
        }
        
    }

    // TODO: STUB
    private void loop() {
        System.out.println("[loop]");
        while (this.run) {
            // print prompt
            this.printf("%s> ","test");

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
        app.start();        
    }
}
