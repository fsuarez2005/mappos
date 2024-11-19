/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.textclient;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franksuarez
 */
public class Utility {
    /** Configure root Logger.
     * 
     */
    public static void configRootLoggerLevel(Level desiredLevel) {
        
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(desiredLevel);
        // set all handlers to desired level
        for (Handler h: rootLogger.getHandlers()) {
            h.setLevel(desiredLevel);
        }
        
    }
}
