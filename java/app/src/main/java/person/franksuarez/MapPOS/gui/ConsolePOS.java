/**
 * Console Point of Sale
 * 
 * DESCRIPTION:
 * 
 * 
 * TODO:
 * - []
 * - []
 * - []
 * 
 * 
 * 
 */




package person.franksuarez.MapPOS.gui;

import java.io.Console;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;



class ShellCommand {}


class Shell {
    protected String prompt = "> ";
    
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
        System.out.printf("input length = %s\n",line.length());
        switch (line.toLowerCase()) {
            case "commands" -> {
                printFunction.accept("Command List: \n");
                this.listCommands();
            }
            case "quit" -> this.runLoop = false;
            default -> {
            }
            
        }
        
    }
    
    // ------------------------------------------------------------
    
    public void loop() {
        String line;

        while (runLoop) {
            printFunction.accept(String.format("%s ", this.prompt));
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


/** ConsoleApp interacts with user via terminal.
 *
 * @author franksuarez
 */
public class ConsolePOS {
    public Console cons;

    public ConsolePOS() {
        this.cons = System.console();
    }
    
    public String getInput() {
        String line = cons.readLine();
        return line;
    }
    
    public void print(String s) {
        cons.printf(s);
    }

    public static void main(String[] args) throws Exception {
        ConsolePOS app = new ConsolePOS();
        
        Shell cs = new Shell();
        
        // TODO: change this back to a Supplier<String> argument
        cs.setGetInputFunction(
                () -> {
                    String line = app.getInput();
                    return line;
                }
        );
        
        

        // TODO: change this back to a Consumer<String> argument
        cs.setPrintFunction(
                (s) -> {
                    app.print(s);
                }
        );
        
        
        cs.start();
    }
}
