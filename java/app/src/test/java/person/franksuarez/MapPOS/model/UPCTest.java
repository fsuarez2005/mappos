/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.function.Predicate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class UPCTest {
    private int[] varData = new int[] {
        0,1,2,3,4,5,6,7,8,9,0,1
    };
    
    private char[] varCharData = new char[] {
        '0','1','2','3','4','5','6','7','8','9','0','1'
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
     * Test of charToInt method, of class UPC.
     */
    @Test
    public void testCharToInt() throws Exception {
        System.out.println("charToInt");
        char c = '1';
        int expResult = 1;
        int result = UPC.charToInt(c);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setData method, of class UPC.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        int[] data = this.varData;
                
        UPC instance = new UPC();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class UPC.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        UPC instance = new UPC();
        instance.setData(varData);
        int[] expResult = this.varData;
        int[] result = instance.getData();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of getCharData method, of class UPC.
     */
    @Test
    public void testGetCharData() {
        System.out.println("getCharData");
        UPC instance = new UPC();
        instance.setCharData(varCharData);
        
        
        char[] expResult = this.varCharData;
        char[] result = instance.getCharData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCharData method, of class UPC.
     */
    @Test
    public void testSetCharData() {
        System.out.println("setCharData");
        char[] charData = varCharData;
        UPC instance = new UPC();
        instance.setCharData(charData);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIsCharValid method, of class UPC.
     */
    @Test
    public void testGetIsCharValid() {
        System.out.println("getIsCharValid");
        UPC instance = new UPC();
        Predicate<Character> expResult = null;
        Predicate<Character> result = instance.getIsCharValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsCharValid method, of class UPC.
     */
    @Test
    public void testSetIsCharValid() {
        System.out.println("setIsCharValid");
        Predicate<Character> isCharValid = null;
        UPC instance = new UPC();
        instance.setIsCharValid(isCharValid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsValid method, of class UPC.
     */
    @Test
    public void testIsIsValid() {
        System.out.println("isIsValid");
        UPC instance = new UPC();
        boolean expResult = false;
        boolean result = instance.isIsValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsValid method, of class UPC.
     */
    @Test
    public void testSetIsValid() {
        System.out.println("setIsValid");
        boolean isValid = false;
        UPC instance = new UPC();
        instance.setIsValid(isValid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromString method, of class UPC.
     */
    @Test
    public void testFromString() {
        System.out.println("fromString");
        String dataString = "";
        UPC instance = new UPC();
        instance.fromString(dataString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateDigitOnlyData method, of class UPC.
     */
    @Test
    public void testGenerateDigitOnlyData() throws Exception {
        System.out.println("generateDigitOnlyData");
        UPC instance = new UPC();
        instance.generateDigitOnlyData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validate method, of class UPC.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        UPC instance = new UPC();
        instance.validate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invalidate method, of class UPC.
     */
    @Test
    public void testInvalidate() {
        System.out.println("invalidate");
        UPC instance = new UPC();
        instance.invalidate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormatLength method, of class UPC.
     */
    @Test
    public void testSetFormatLength() {
        System.out.println("setFormatLength");
        int formatLength = 0;
        UPC instance = new UPC();
        instance.setFormatLength(formatLength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormatLength method, of class UPC.
     */
    @Test
    public void testGetFormatLength() {
        System.out.println("getFormatLength");
        UPC instance = new UPC();
        int expResult = 0;
        int result = instance.getFormatLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UPC.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UPC instance = new UPC();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
