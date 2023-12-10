/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.model;

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
public class UPCTest {
 
    
    
    public UPCTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {

    }
    
    @AfterEach
    public void tearDown() {
    }



    /**
     * Test of setData method, of class UPC.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String upcStr = "0123456789";
        UPC instance = new UPC();
        instance.setData(upcStr);
        
    }

    /**
     * Test of initializeValues method, of class UPC.
     */
    @Test
    public void testInitializeValues() {
        //System.out.println("initializeValues");
        //UPC instance = new UPC();
        //instance.initializeValues();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convertStringToByteArray method, of class UPC.
     */
    @Test
    public void testConvertStringToByteArray() {
        System.out.println("convertStringToByteArray");
        String numStr = "123456789";
        UPC instance = new UPC();
        byte[] expResult = new byte[] {1,2,3,4,5,6,7,8,9};
        byte[] result = instance.convertStringToByteArray(numStr);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UPC.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UPC instance = new UPC();
        instance.setData("01234567890");
        
        String expResult = "01234567890";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCheckDigit method, of class UPC.
     */
    @Test
    public void testCalculateCheckDigit() {
        System.out.println("calculateCheckDigit");
        UPC instance = new UPC();
        instance.calculateCheckDigit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    
    


    
    



    

    
}
