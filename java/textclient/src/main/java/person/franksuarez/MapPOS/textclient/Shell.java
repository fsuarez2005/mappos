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
package person.franksuarez.MapPOS.textclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import person.franksuarez.MapPOS.common.model.POS;

/**
 *
 * @author franksuarez
 */
public class Shell {

    protected List<String> stack;

    protected String prompt = "> ";
    private POS pos;
    private Mode mode = Mode.COMMAND;

    private boolean running = true;

    private InputStream in;
    private OutputStream out;

    private BufferedReader reader;
    private BufferedWriter writer;

    enum Mode {
        COMMAND, POS, DEBUG
    }

    public Shell() {
        this.in = System.in;
        this.out = System.out;
        
        this.reader = new BufferedReader(new InputStreamReader(this.in));
        this.writer = new BufferedWriter(new OutputStreamWriter(this.out));
        
        this.stack = new ArrayList<>();
        
    }

    public void initialize() {
        // You can load configuration or connect to services here
    }

    public String getPrompt() {
        String output = String.format("%s %s", this.mode.toString(), this.prompt);
        return output;
    }

    public void printPrompt() throws IOException {
        writer.write(getPrompt());
        writer.flush();

    }

    private List<String> tokenize(String line) {
        return List.of(line.trim().split("\\s+"));
    }

    protected void evaluate(String token) throws IOException {

        if (token.equalsIgnoreCase("quit")) {
            System.exit(0);

        } else if (token.equalsIgnoreCase("pos")) {

        } else if (token.equalsIgnoreCase(".s")) {
            this.writer.write("Stack:\n");
            this.writer.flush();
            for (String n : this.stack) {
                this.writer.write(n);
                this.writer.write("\n");
                this.writer.flush();
            }
        } else { // append string to this.stack
            this.stack.add(token);
        }
    }

    protected void processTransaction() {

    }

    protected void parseLine(String userInput) throws EOFException, IOException {
        if (userInput == null) {
            throw new EOFException();
        }

        List<String> tokenList = this.tokenize(userInput);

        if (tokenList.isEmpty()) {
            return;
        }

        // if anything is not a known word, place on stack
        for (String s : tokenList) {
            this.evaluate(s);

        }

    }

    public void start() throws IOException {
        initialize();
        loop();
    }

    protected void loop() throws IOException {
        while (running) {
            printPrompt();
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

}
