/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franksuarez
 */
public class Utility {
    public static boolean isSerializable(Object o) {
        boolean output = true;
        
        try {
            new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(o);
        } catch (IOException ex) {
            output = false;
            
        }
        return output;
    }

    /** Configure root Logger.
     *
     */
    public static void configRootLoggerLevel(Level desiredLevel) {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(desiredLevel);
        // set all handlers to desired level
        for (Handler h : rootLogger.getHandlers()) {
            h.setLevel(desiredLevel);
        }
    }
    
    
    
    
    
    
}
