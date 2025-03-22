/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class LinearBarcodeTest {
    private LinearBarcode data;
    
    
    private String testUPC1Str = "611269001303";
    
    
    
    public LinearBarcodeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.data = new LinearBarcode();
        this.data.fromString(testUPC1Str);
        
        this.data.formatLength = 12;
        this.data.hasCheckDigit = true;
        
        this.data.isCharValid = (Character c) -> {
            return (Character.isDigit(c));
        };
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of areAllCharsValid method, of class LinearBarcode.
     */
    @Test
    public void testAreAllCharsValid() {
        System.out.println("areAllCharsValid");
        //LinearBarcode instance = new LinearBarcode();
        
        
        
        boolean expResult = false;
        boolean result = this.data.areAllCharsValid();
        //assertEquals(expResult, result);
        
    }

    /**
     * Test of isValid method, of class LinearBarcode.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        
        boolean expResult = true;
        boolean result = this.data.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isCorrectFormatLength method, of class LinearBarcode.
     */
    @Test
    public void testIsCorrectFormatLength() {
        System.out.println("isCorrectFormatLength");
       
        boolean expResult = true;
        boolean result = this.data.isCorrectFormatLength();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hasOnlyDigits method, of class LinearBarcode.
     */
    @Test
    public void testHasOnlyDigits() {
        System.out.println("hasOnlyDigits");
        
        boolean expResult = true;
        boolean result = this.data.hasOnlyDigits();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of toIntArray method, of class LinearBarcode.
     */
    @Test
    public void testToIntArray() throws Exception {
        System.out.println("toIntArray");
        
        int[] expResult = new int[] {6,1,1,2,6,9,0,0,1,3,0,3};
        int[] result = this.data.toIntArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class LinearBarcode.
     */
    @Disabled
    @Test
    public void testToString() {
        System.out.println("toString");
        LinearBarcode instance = new LinearBarcode();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
