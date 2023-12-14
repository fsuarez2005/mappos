/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class UPCALinearBarcodeTest {
    
    public UPCALinearBarcodeTest() {
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
     * Test of createBooleanPattern method, of class UPCALinearBarcode.
     */
    @Test
    public void testCreateBooleanPattern() {
        System.out.println("createBooleanPattern");
        String patternStr = "1010";
        boolean[] expResult = new boolean[] {true,false,true,false};
        boolean[] result = null;
        try {
            result = UPCALinearBarcode.createBooleanPattern(patternStr,false);
        } catch (Exception ex) {
            Logger.getLogger(UPCALinearBarcodeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            assertArrayEquals(expResult, result);
    }
    
    

    /**
     * Test of initializeStaticProperties method, of class UPCALinearBarcode.
     */
    @Test
    public void testInitializeStaticProperties() {
        System.out.println("initializeStaticProperties");
        UPCALinearBarcode.initializeStaticProperties();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPatterns method, of class UPCALinearBarcode.
     */
    @Test
    public void testGetAllPatterns() {
        System.out.println("getAllPatterns");
        UPCALinearBarcode.getAllPatterns();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of initializeBarcodeData method, of class UPCALinearBarcode.
     */
    @Test
    public void testInitializeBarcodeData() {
        System.out.println("initializeBarcodeData");
        UPCALinearBarcode instance = new UPCALinearBarcode();
        instance.initializeBarcodeData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDigit method, of class UPCALinearBarcode.
     */
    @Test
    public void testSetDigit() {
        System.out.println("setDigit");
        int index = 0;
        int value = 0;
        UPCALinearBarcode instance = new UPCALinearBarcode();
        instance.setDigit(index, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBarcodeData method, of class UPCALinearBarcode.
     */
    @Test
    public void testPrintBarcodeData() {
        System.out.println("printBarcodeData");
        UPCALinearBarcode instance = new UPCALinearBarcode();
        instance.setDigit(0, 5);
        
        
        
        instance.printBarcodeData();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
