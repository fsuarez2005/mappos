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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import person.franksuarez.MapPOS.common.model.Command;
import person.franksuarez.MapPOS.common.model.POS;

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

    // =======================================================
    private void setupCommands() {
        Command quitCmd = new Command("quit", (t) -> {
            this.running = false;
        });
        commands.put("quit", quitCmd);

        Command helpCmd = new Command("help", (t) -> {
            
            try {
                writeln("HELP: Commands:");
                writeln("");
                
                commands.forEach((name, cmd) -> {
                    try {
                        writeln(String.format("\t%s\t%s",name,cmd.getUsage()));
                        
                    } catch (IOException ex) {
                        System.getLogger(Shell.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                });
            } catch (IOException ex) {
                System.getLogger(Shell.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
        
        
        
        });
        commands.put("help", helpCmd);
        
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

            /*
            public static Token lex(String input) {
                Token output = null;

                if (input == null) {
                    output = new Token(TokenType.UNKNOWN, "");
                    return output;
                }

                switch (input.trim()) {
                    case "help", "exit", "pos", "command", "status" -> {
                        output = new Token(TokenType.COMMAND, input.trim());
                    }

                    default -> {
                        UPCA upc = new UPCA();
                        upc.fromString(input.trim());
                        if (upc.isValid()) {
                            output = new Shell.Token(TokenType.UPC, input.trim());
                            break;
                        }

                        output = new Shell.Token(TokenType.UNKNOWN, input.trim());

                    }

                }

                return output;
            }
             */
            @Override
            public String toString() {
                String output = String.format("<%s / %s / %s>", super.toString(), lexeme, type.name());
                return output;
            }

        }

        public Token lex(String token) {
            String trimmedToken = token.trim();
            Set<String> commandStringList = commands.keySet();

            if (commandStringList.contains(trimmedToken)) {
                return new Token(Token.TokenType.COMMAND,trimmedToken);
            }

            return new Token(Token.TokenType.UNKNOWN, trimmedToken);

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
            return lexer.lex(t);
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
            
            // command may have altered environment
            if (this.running == false) {
                break;
            }
            
        }

    }

    protected void evaluate(Lexer.Token token) throws IOException {
        switch (token.type) {
            case COMMAND -> {
                writeln("Command");
                Command cmd = commands.get(token.lexeme);
                cmd.accept("");
                
            }

            case UPC -> {
                writeln("UPC");
            }

            case UNKNOWN -> {

            }

            default -> {

            }

        }
        
        

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
