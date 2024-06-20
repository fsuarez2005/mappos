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
import org.junit.jupiter.api.Disabled;
import person.franksuarez.MapPOS.exception.InvalidIdentifier;

/**
 *
 * @author franksuarez
 */
public class AddressTest {
    
    public AddressTest() {
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
     * Test of format method, of class Address.
     */
    @Test
    @Disabled
    public void testFormat() {
        System.out.println("format");
        String fmt = "";
        Address instance = new Address();
        String expResult = "";
        String result = instance.format(fmt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class Address.
     */
    @Test
    @Disabled
    public void testGetContent() throws Exception {
        System.out.println("getContent");
        String identifier = "";
        Address instance = new Address();
        String expResult = "";
        String result = instance.getContent(identifier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testAddress() throws InvalidIdentifier {
        Address instance = new Address();
        instance.addValidIdentifier("houseNumber");
        instance.addValidIdentifier("streetName");
        
        instance.setFormatCodeIdentifier("%h", "houseNumber");
        instance.setFormatCodeIdentifier("%s", "streetName");
        
        
        instance.setContent("houseNumber", "123");
        instance.setContent("streetName", "Fake St.");
        
        
        String output = instance.format("%h %s");
        
        System.out.printf("%s%n",output);
        
        
        
        
    }
    
}
