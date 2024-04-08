/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.gui;

import java.io.Console;



/** ConsoleApp interacts with user via terminal.
 *
 * @author franksuarez
 */
public class ConsoleApp {
    public Console cons;

    public ConsoleApp() {
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
        ConsoleApp app = new ConsoleApp();
        
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
