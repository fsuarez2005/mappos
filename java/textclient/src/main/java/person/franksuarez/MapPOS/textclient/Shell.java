// Purpose: interpret text commands
package person.franksuarez.MapPOS.textclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    protected String prompt = "> ";
    private POS pos;

    private boolean running = true;

    private InputStream in;
    private OutputStream out;

    private BufferedReader reader;
    private BufferedWriter writer;
    

    public Shell() {
        this.in = System.in;
        this.out = System.out;
        
        this.reader = new BufferedReader(new InputStreamReader(this.in));
        this.writer = new BufferedWriter(new OutputStreamWriter(this.out));
        
        
    }
    
    
    
    
    
    
    public void initialize() {
        
        
    }

    public String getPrompt() {
        return prompt;
    }
    
    public void printPrompt() throws IOException {
        this.writer.write(this.getPrompt());
        this.writer.flush();
    }
    
    protected List<String> tokenize(String line) {
        var output = new ArrayList<String>();
        var scanner = new Scanner(line);
        while (scanner.hasNext()) {
            output.add(scanner.next());
        }
        return output;
    }

    protected void evaluate(String userInput) throws IOException {
        // tokenize
        
        List<String> tokenList = this.tokenize(userInput);
        this.writer.write(String.format("User Input: %s%n", tokenList.toString()));
        this.writer.flush();
    }

    public void start() throws IOException {
        // initialize
        this.initialize();
        // loop
        this.loop();

    }

    protected void loop() throws IOException {
        while (running) {
            // print prompt
            this.printPrompt();
            
            // get input 
            String userInput = this.reader.readLine();
            
            
            
            // evaluate input
            this.evaluate(userInput);
            
            // print output
        }

    }

}
