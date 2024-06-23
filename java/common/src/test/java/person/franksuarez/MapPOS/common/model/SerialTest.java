/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class SerialTest {
    public SerialTest() {
        
        
        
    }
    
    /** Returns true is java.io.Serializable works.
     * 
     * @param o
     * @return 
     */
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
    
    
    @Test
    public void test1() {
        UPCA o = new UPCA();
        
        
        boolean o_serializable = isSerializable(o);
        
        
        System.out.printf("is o serializable? %b%n",o_serializable);
        
    }
    
}
