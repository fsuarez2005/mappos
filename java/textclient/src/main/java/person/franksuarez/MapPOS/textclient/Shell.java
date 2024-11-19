/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.textclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;


/** Subclassable Shell.
 *
 * @author franksuarez
 */
public class Shell {
    private static final Logger LOG = Logger.getLogger(Shell.class.getName());
    
    
    protected String prompt = "> ";
    
    // NOTE: Shell should be simple.
    protected Consumer<String> commandProcessor;
    protected HashMap<String, person.franksuarez.MapPOS.common.model.Command> commands;
    
    
    
    protected boolean running = true;
    
    
    protected BufferedReader reader;
    protected BufferedWriter writer;

    public final boolean isRunning() {
        return running;
    }

    public final void setRunning(boolean running) {
        this.running = running;
    }

    public final BufferedReader getReader() {
        return reader;
    }

    public final void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public final BufferedWriter getWriter() {
        return writer;
    }

    public final void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }


    /** Preprocess the prompt.
     * 
     * Could be used to substitute arguments.
     * @param prompt
     * @return 
     */
    protected String promptPreprocess(String prompt) {
        return prompt;
    }
    
    public final String getPrompt() {
        String output = this.promptPreprocess(this.prompt);
        return output;
    }

    public final void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public final void initialize() {
        System.out.println("Shell.initialize");
        this.setReader(new BufferedReader(new InputStreamReader(System.in)));
        this.setWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public final String readLine() {
        LOG.entering("Shell", "readLine");
        
        String line = "";
        try {
            line = this.reader.readLine();
        } catch (IOException ex) {
            System.out.printf("%s%n", ex.toString());
            Logger.getLogger(TextPOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    public final void printf(String fmt, Object... args) throws IOException {
        
        String output = String.format(fmt, args);
        this.writer.write(output);
        this.writer.flush();
    }

    protected void parseLine(String line) throws IOException {
        this.printf("User Input: %s%n",line);
    }
    
    protected List<String> tokenize(String line) {
        var output = new ArrayList<String>();
        var scanner = new Scanner(line);
        while (scanner.hasNext()) {
            output.add(scanner.next());
        }
        return output;
    }
    
    
    
    protected void loop() throws IOException {
        System.out.println("Shell.loop");
        while (this.running) {
            this.printf("%s", this.getPrompt());
            
            String userInput = this.readLine();
            
            if (userInput == null) {
                System.out.println("user input was null");
                break;
            }
            this.parseLine(userInput);
        }
        
    }

    public void start() throws IOException {
        this.initialize();
        this.loop();
    }
    
    

}
