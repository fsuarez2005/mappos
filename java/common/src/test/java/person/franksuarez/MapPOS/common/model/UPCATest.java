/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author franksuarez
 */
public class UPCATest {
    private UPCA data;
    
    
    private String testUPC1Str = "611269001303";
    
    
    
    public UPCATest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.data = new UPCA();
        this.data.fromString(testUPC1Str);
        
        
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void testConstructor() {
        UPCA a = new UPCA();
        //System.out.printf("%s%n%b%n",a.isCharValidOld.toString(),a.isCharValidOld.test('a'));
        
        
    }
    
    
    /**
     * Test of calculateCheckDigit method, of class UPCA.
     */
    @Disabled("")
    @Test
    public void testCalculateCheckDigit() throws Exception {
        System.out.println("calculateCheckDigit");
        UPCA instance = new UPCA();
        int expResult = 0;
        int result = instance.calculateCheckDigit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class UPCA.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        //UPCA instance = new UPCA();
        boolean expResult = true;
        boolean result = this.data.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void fail_testIsValid() {
        System.out.println("fail_isValid");
        UPCA instance = new UPCA();
        
        
        boolean expResult = true;
        boolean result = this.data.isValid();
        assertEquals(expResult, result);
        
        
        
    }

    /**
     * Test of hasValidCheckDigit method, of class UPCA.
     */
    @Test
    public void testHasValidCheckDigit() throws Exception {
        System.out.println("hasValidCheckDigit");
        //UPCA instance = new UPCA();
        boolean expResult = true;
        boolean result = this.data.hasValidCheckDigit();
        assertEquals(expResult, result);
    }
    
}
