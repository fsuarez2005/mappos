/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.gui;

import java.io.Console;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.exception.InvalidFormat;
import person.franksuarez.MapPOS.model.UPCA;

class ConsoleShell {
    private Console cons;
    private boolean runLoop = true;
    private String prompt = "[ConsoleShell]> ";
    
    private BiConsumer<ConsoleShell,String> parseLineCallback;
    
    public ConsoleShell() throws Exception {
        cons = System.console();
                
        if (cons == null) {
            throw new Exception("Console not available.");
        }
    }
    
    public void printf(String fmt, Object... args) {
        cons.printf(fmt, args);
    }
    
    public void quitLoop() {
        runLoop = false;
    }
    
    public void setParseLineCallback(BiConsumer<ConsoleShell,String> callback) {
        parseLineCallback = callback;
    }
    
    private void parseLine(String line) {
        cons.printf("LINE: %s\n", line);
        
        if (parseLineCallback != null) {
            parseLineCallback.accept(this, line);
        } else {
            cons.printf("ERROR: parseLineCallback not defined.\n");
        }   
    }
    
    public void loop() {
        while (runLoop) {
            cons.printf("%s", prompt);
            String line = cons.readLine();
            if (line == null) {
                runLoop = false;
                break;
            }
            parseLine(line);
        }
    }
    
    public void start() {
        loop();
        
    }
}

/**
 *
 * @author franksuarez
 */
public class ConsoleApp {
    
    public static void upcCheckCallback(ConsoleShell cs, String line) {
        UPCA u = new UPCA();
        
        try {
            u.setData(line);
            boolean validCheckdigit = u.hasValidCheckDigit();
            cs.printf("has valid checkdigit = "+String.valueOf(validCheckdigit));
        } catch (InvalidFormat ex) {
            cs.printf("Invalid UPC format");
            //Logger.getLogger(ConsoleApp.class.getName()).log(Level.SEVERE, "Invalid Format", ex);
        }
    }
    
    
    public static void parseLine(ConsoleShell cs, String line) {
        cs.printf(line);
        
        
        
        switch (line) {
            case "quit":
                cs.quitLoop();
                break;
            case "list":
                break;
            default:
                break;
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        ConsoleShell cs = new ConsoleShell();
        //cs.setParseLineCallback(ConsoleApp::parseLine);
        cs.setParseLineCallback(ConsoleApp::parseLine);
        
        cs.start();
    }
}
