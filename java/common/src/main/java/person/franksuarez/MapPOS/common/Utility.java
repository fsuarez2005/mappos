/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
            //Logger.getLogger(SerialTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    
}
