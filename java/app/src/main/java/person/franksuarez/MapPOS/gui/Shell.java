package person.franksuarez.MapPOS.gui;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/** Console App Shell.
 * 
 * Purpose: To parse and interpret commands.
 * 
 * @author franksuarez
 */

class ShellCommand {






}


public class Shell {

    
    protected HashMap<String,ShellCommand> commands;
    
    
    protected boolean runLoop = true;
    
    protected Consumer<String> printFunction;
    protected Supplier<String> getInputFunction;

    // ------------------------------------------------------------
    
    public Shell() {
        this.commands = new HashMap<>();
    }
    
    // ------------------------------------------------------------
    
    public Supplier<String> getGetInputFunction() {
        return getInputFunction;
    }

    public void setGetInputFunction(Supplier<String> getInputFunction) {
        this.getInputFunction = getInputFunction;
    }

    public Consumer<String> getPrintFunction() {
        return printFunction;
    }

    public void setPrintFunction(Consumer<String> printFunction) {
        this.printFunction = printFunction;
    }
    
    // ------------------------------------------------------------
    
    public void addCommand(String commandName, ShellCommand obj) {
        this.commands.put(commandName, obj);
    }
    
    public void listCommands() {
        printFunction.accept(this.commands.toString());
    }
    
    public void deleteCommand() {}
    
    // ------------------------------------------------------------
    
    public void setState() {}
    public void getState() {}
    
    // ------------------------------------------------------------
    
    public void quitLoop() {
        runLoop = false;
    }

    // ------------------------------------------------------------
    
    public void evaluate(String line) {
        switch (line.toLowerCase()) {
            case "commands":
                printFunction.accept("Command List: \n");
                this.listCommands();
                
                break;
            default:
                break;
            
        }
        
    }
    
    private void parseLine(String line) {
        switch (line.toLowerCase()) {
            case "upc":
                printFunction.accept("Verify UPC: \n");
                
                break;
            case "quit":
                this.quitLoop();
                break;
            default:
                break;
        }
        
        
    }
    
    // ------------------------------------------------------------
    
    public void loop() {
        String line;

        while (runLoop) {
            //printFunction.accept(String.format("%s ", this.prompt));
            line = getInputFunction.get();
            this.evaluate(line);
        }
    }
    
    // ------------------------------------------------------------
    
    public void start() {
        this.addTestCommands();
        
        loop(); 
    }
    
    
    
    
    
    public void addTestCommands() {
        this.addCommand("test", new ShellCommand());
        
        
    }

}
