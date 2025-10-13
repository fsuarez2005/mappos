// Purpose: interpret text commands
// stack based language
/**
 * Commands:
 * QUIT - quit program
 * HELP -  show help information
 * STATUS -  shows status information
 * CONNECT - connect to server
 * SETTINGS - show settings
 * MODE - show mode
 * POS - enter POS mode
 * IDLE - enter idle mode
 *
 *
 *
 * Stack operations:
 * SHOWSTACK
 * CLEARSTACK
 */
/*
   <line-input> ::= 



    <command> ::= "help" | "exit"





 */
package person.franksuarez.MapPOS.textclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import person.franksuarez.MapPOS.common.model.POS;

/**
 *
 * @author franksuarez
 */
public class Shell {
    private boolean doPrintPrompt = true;
    protected String prompt = "> ";
    private POS pos;
    private ShellMode mode = ShellMode.COMMAND;

    private boolean running = true;

    private BufferedReader reader;
    private BufferedWriter writer;

    // =======================================================
    public static enum ShellMode {
        COMMAND, POS, DEBUG
    }

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

        public static Token lex(String input) {
            Token output = null;

            if (input == null) {
                output = new Token(TokenType.UNKNOWN, "");
                return output;
            }

            switch (input.trim()) {
                case "help" -> {
                    output = new Token(TokenType.COMMAND, input.trim());
                }

                default -> {
                    output = new Token(TokenType.UNKNOWN, input.trim());

                }

            }

            return output;
        }
        
        
        @Override
        public String toString() {
            String output = String.format("<%s / %s / %s>",super.toString(),lexeme,type.name());
            return output;
        }

    }

    // =======================================================
    public Shell() {
        //this.stack = new ArrayList<>();
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
    private List<Token> tokenizeInputLine(String line) {
        List<String> tokenStringList = List.of(line.trim().split("\\s+"));
        
        List<Token> tokenList = tokenStringList.stream().map((t) -> {
            return Token.lex(t);
        }).collect(java.util.stream.Collectors.toList());
        //return List.of(line.trim().split("\\s+"));
        
        return tokenList;
    }
    
    protected void parseLine(String userInput) throws EOFException, IOException {
        if (userInput == null) {
            throw new EOFException();
        }

        List<Token> tokenList = this.tokenizeInputLine(userInput);

        if (tokenList.isEmpty()) {
            return;
        }

        // if anything is not a known word, place on stack
        for (Token s : tokenList) {
            System.out.printf("Token: %s%n",s.toString());
            
            
            //this.evaluate(s);
        }
    }
    


    protected void evaluate(String token) throws IOException {

    }



    // =======================================================
    protected void processTransaction() {

    }

    protected void printHelp() {
        String helpString = "MAPPos\n"
                + "version: 0.0\n"
                + "\n"
                + "Commands:\n"
                + "help\tPrints this.\n\n";

        try {
            writer.write(helpString);
        } catch (IOException ex) {
            System.getLogger(Shell.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
