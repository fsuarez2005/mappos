// Purpose: interpret text commands
// stack based language
/** Commands.
 * 
 * QUIT - quit program
 * HELP -  show help information
 * STATUS -  shows status information
 * CONNECT - connect to server
 * SETTINGS - show settings
 * MODE - show mode
 * POS - enter POS mode
 * COMMAND - enter command mode
 * 
 * TRANSVOID - Voids entire transaction
 * ITEMVOID - Voids an item
 * TENDERVOID - 
 * SUSPEND - 
 * RESUME - 
 * PLU - Look up PLU by description
 * TOTAL - Finalize transaction
 * CASH - Enter cash amount to tender
 * CREDIT - Enter credit amount
 *
 */

package person.franksuarez.MapPOS.textclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import person.franksuarez.MapPOS.common.model.Command;
import person.franksuarez.MapPOS.common.model.POS;
import person.franksuarez.MapPOS.common.model.UPCA;

/**
 *
 * @author franksuarez
 */
public class Shell {

    private Lexer lexer;

    private boolean doPrintPrompt = true;
    protected String prompt = "> ";

    private Map<String, Command> commands;

    private POS pos;
    private ShellMode mode = ShellMode.COMMAND;

    private boolean running = true;

    private BufferedReader reader;
    private BufferedWriter writer;
    
    // tells tokenizer to discard rest of line
    private boolean skipRestOfLine = false;

    // =======================================================
    private void setupCommands() {
        Command quitCmd = new Command("quit", (t) -> {
            this.running = false;
        });
        quitCmd.setShortDescription("Quits the POS.");
        commands.put("quit", quitCmd);

        Command helpCmd = new Command("help", (t) -> {
            
            try {
                writeln("HELP: Commands:");
                writeln("---------------");
                
                commands.forEach((name, cmd) -> {
                    try {
                        writeln(String.format("\t%s\t%s",name,cmd.getShortDescription()));
                        writeln("---------------");
                    } catch (IOException ex) {
                        System.getLogger(Shell.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                });
            } catch (IOException ex) {
                System.getLogger(Shell.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
        
        
        
        });
        helpCmd.setShortDescription("Shows help.");
        commands.put("help", helpCmd);
        
        
        Command posCmd = new Command("pos", (t) -> {
            this.mode = ShellMode.POS;
        });
        posCmd.setShortDescription("Switch to POS Mode.");
        commands.put("pos",posCmd);
    }

    public static enum ShellMode {
        COMMAND, POS, DEBUG
    }

    /**
     * Creates Tokens from string tokens.
     *
     */
    public class Lexer {

        public static class Token {

            public static enum TokenType {
                UPC,
                COMMAND,
                UNKNOWN

            }
            public final TokenType type;
            public final String lexeme;

            public Token(TokenType type, String lexeme) {
                this.type = type;
                this.lexeme = lexeme;
            }

            @Override
            public String toString() {
                String output = String.format("<%s / %s / %s>", super.toString(), lexeme, type.name());
                return output;
            }

        }

        public Token lex(String token) throws IOException {
            String trimmedToken = token.trim();
            Set<String> commandStringList = commands.keySet();
            
            
            UPCA upc = new UPCA();
            upc.fromString(trimmedToken);
            if (upc.isValid()) {
                return new Token(Token.TokenType.UPC, trimmedToken);
            } else if (commandStringList.contains(trimmedToken)) {
                return new Token(Token.TokenType.COMMAND,trimmedToken);
            } else {
                return new Token(Token.TokenType.UNKNOWN, trimmedToken);
            }

        }

    }

    // =======================================================
    public Shell() {
        this.commands = new Hashtable<>();

        this.setupCommands();
        this.lexer = new Lexer();

    }

    public void write(String s) throws IOException {
        this.writer.write(s);
    }

    public void writeln(String s) throws IOException {
        this.writer.write(
                String.format("%s%n", s)
        );
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public String getPrompt() {
        String output = String.format("%s%s", this.mode.toString(), this.prompt);
        return output;
    }

    public void printPrompt() throws IOException {
        writer.write(getPrompt());
        writer.flush();

    }

    // =======================================================
    public void start() throws IOException {
        loop();
    }
    // =======================================================

    protected void loop() throws IOException {
        while (running) {
            if (doPrintPrompt) {
                printPrompt();
            }
            String userInput = reader.readLine();

            if (userInput == null) {
                writer.write("EOF\n");
                writer.flush();
                break;
            }

            try {
                parseLine(userInput);
            } catch (IOException e) {
                writer.write("Error: " + e.getMessage() + "\n");
                writer.flush();
            }

        }

    }

    /**
     *
     *
     *
     *
     * @param line
     * @return
     */
    private List<Shell.Lexer.Token> tokenizeInputLine(String line) {
        // tokens are separated by white space
        List<String> tokenStringList = List.of(line.trim().split("\\s+"));

        // convert token Strings into token Tokens
        List<Shell.Lexer.Token> tokenList = tokenStringList.stream().map((t) -> {
            
            Lexer.Token token = null;
            try {
                token = lexer.lex(t);
            } catch (IOException ex) {
                System.getLogger(Shell.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                
            }
            
            return token;
        }).collect(java.util.stream.Collectors.toList());

        return tokenList;
    }

    protected void parseLine(String userInput) throws EOFException, IOException {
        if (userInput == null) {
            throw new EOFException();
        }

        List<Lexer.Token> tokenList = this.tokenizeInputLine(userInput);

        for (Lexer.Token s : tokenList) {

            evaluate(s);
            
            if (this.skipRestOfLine) {
                break;
            }
            // command may have altered environment
            if (! this.running) {
                break;
            }
            
        }

    }

    protected void evaluate(Lexer.Token token) throws IOException {
        if (this.mode == ShellMode.COMMAND) {
        
        
        
        
        switch (token.type) {
            case COMMAND -> {
                // process command
                
                
                writeln("Command");
                Command cmd = commands.get(token.lexeme);
                cmd.accept("");
                
            }

            case UNKNOWN -> {
                writeln("Unknown input.");
            }

            default -> {
                writeln("Invalid input");
            }

        }
        
        } else if (this.mode == ShellMode.POS) {
            switch (token.type) {
                case COMMAND -> {
                    // process commands in POS mode
                    switch (token.lexeme) {
                        case "command" -> {
                            this.mode = ShellMode.COMMAND;
                        }
                        case "quit" -> {
                            this.running = false;
                            
                        }
                        
                    }
                    
                }
                case UPC -> {
                    // append UPC to current transaction
                    
                    write(String.format("You entered UPC: %s%n", token.lexeme));
                    
                    
                }
                
                case UNKNOWN -> {
                    
                    
                    
                }
                
                default -> {
                    
                    
                }
                
            }
            
            
            
            
        }
        
        

    }


}
