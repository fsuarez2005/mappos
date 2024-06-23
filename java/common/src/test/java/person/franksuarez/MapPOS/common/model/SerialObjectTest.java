/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franksuarez
 */
public class SerialObjectTest {
    
    public SerialObjectTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    

    
    
    
    @Test
    public void testSerial() throws IOException {
        SerialObject s = new SerialObject("Frank");
        
        
        
        ObjectOutputStream oos = new ObjectOutputStream(System.out);


        //FileOutputStream fileout = new FileOutputStream("/Users/franksuarez/Desktop/testobject.txt");
        //ObjectOutputStream oos = new ObjectOutputStream(fileout);
        
        
        oos.writeObject(s);
        oos.flush();
        oos.close();
        System.out.print("END");
        System.out.println("");
        //System.out.flush();
        
        
        
    }
    
}
