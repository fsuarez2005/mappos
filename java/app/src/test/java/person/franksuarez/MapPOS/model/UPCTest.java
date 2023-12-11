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
    String[] goodUPCs = new String[] {
        "190808004765"
    };
    
    
    
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
     * Test of calculateCheckDigit method, of class UPC.
     */
    @Test
    public void testCalculateCheckDigit() {
        System.out.println("calculateCheckDigit");
        UPC instance = new UPC();
        instance.setData("190808004765");
        int expResult = 5;
        int result = instance.calculateCheckDigit();
        assertEquals(expResult, result);
    }

    /**
     * Test of setData method, of class UPC.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String upcStr = "190808004765";
        UPC instance = new UPC();
        instance.setData(upcStr);
        
        int[] data = instance.getData();
        
        assertArrayEquals(data, new int[] {1,9,0,8,0,8,0,0,4,7,6,5});
    }

    /**
     * Test of getData method, of class UPC.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        UPC instance = new UPC();
        
        instance.setData("190808004765");
        
        int[] expResult = new int[] {1,9,0,8,0,8,0,0,4,7,6,5};
        int[] result = instance.getData();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of hasValidCheckDigit method, of class UPC.
     */
    @Test
    public void testHasValidCheckDigit() {
        System.out.println("hasValidCheckDigit");
        UPC instance = new UPC();
        instance.setData("190808004765");
        
        
        boolean expResult = true;
        boolean result = instance.hasValidCheckDigit();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFormattedCorrectly method, of class UPC.
     */
    @Test
    public void testIsFormattedCorrectly() {
        System.out.println("isFormattedCorrectly");
        boolean expResult = true;
        boolean result = UPC.isFormattedCorrectly("190808004765");
        assertEquals(result, expResult);
    } 

    /**
     * Test of generateBarcode method, of class UPC.
     */
    @Test
    public void testGenerateBarcode() {
        System.out.println("generateBarcode");
        UPC instance = new UPC();
        
        instance.generateBarcode();
        
    }

    /**
     * Test of tempGenerateCode method, of class UPC.
     */
    @Test
    public void testTempGenerateCode() {
        System.out.println("tempGenerateCode");
        UPC instance = new UPC();
        instance.tempGenerateCode();
    }

    /**
     * Test of toString method, of class UPC.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UPC instance = new UPC("190808004765");
        //instance.setData("190808004765");
        
        String expResult = "190808004765";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
