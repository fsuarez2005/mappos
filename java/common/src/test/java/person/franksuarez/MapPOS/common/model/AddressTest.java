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
import person.franksuarez.MapPOS.common.exception.InvalidIdentifier;

/**
 *
 * @author franksuarez
 */
public class AddressTest {
    private Address goodAddress1;
    private Address goodAddress2;
    
    
    
    
    
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
        System.out.println("setUp");
        try {
            goodAddress1 = new Address();
            goodAddress1.addValidIdentifier("name");
            goodAddress1.addValidIdentifier("street");
            goodAddress1.addValidIdentifier("city");
            goodAddress1.addValidIdentifier("state");
            goodAddress1.addValidIdentifier("zipcode");
        } catch (InvalidIdentifier ex) {
            System.getLogger(AddressTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        try {
            goodAddress1.setFormatCode("n", "name");
            goodAddress1.setFormatCode("s", "street");
            goodAddress1.setFormatCode("c", "city");
            goodAddress1.setFormatCode("t", "state");
            goodAddress1.setFormatCode("z", "zipcode");
        } catch (InvalidIdentifier invalidIdentifier) {
            
            
        }

        
        
        
        
    }

    @AfterEach
    public void tearDown() {
    }


    /** TODO: testFormat
     * Test of format method, of class Address.
     */
    @Test
    public void testFormat() {
        System.out.println("format");
        String fmtString = "";
        Address instance = new Address();
        String expResult = "";
        String result = instance.format(fmtString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /** TODO: testGetContent
     * Test of getContent method, of class Address.
     */
    @Test
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

    /** TODO: testSetContent
     * Test of setContent method, of class Address.
     */
    @Test
    public void testSetContent() throws Exception {
        System.out.println("setContent");
        String identifier = "";
        String value = "";
        Address instance = new Address();
        instance.setContent(identifier, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addValidIdentifier method, of class Address.
     */
    @Test
    public void testAddValidIdentifier() throws InvalidIdentifier {
        System.out.println("addValidIdentifier");
        String identifier = "id";
        Address instance = new Address();
        
        
        assertDoesNotThrow(() -> {
            instance.addValidIdentifier(identifier);
        });

    }

    @Test
    public void fail_testAddValidIdentifier_blank() {
        System.out.println("addValidIdentifier");
        String identifier = "";
        Address instance = new Address();

        InvalidIdentifier ex = assertThrows(
                InvalidIdentifier.class,
                () -> {
                    instance.addValidIdentifier(identifier);
                }
        );

    }

    @Test
    public void fail_testAddValidIdentifier_duplicate() throws InvalidIdentifier {
        System.out.println("addValidIdentifier");
        String identifier = "dup";
        Address instance = new Address();

        instance.addValidIdentifier(identifier);
        
        // should fail because duplicate identifier
        InvalidIdentifier ex = assertThrows(
                InvalidIdentifier.class,
                () -> {
                    instance.addValidIdentifier(identifier);
                }
        );

    }

    /**
     * Test of removeValidIdentifier method, of class Address.
     */
    @Test
    public void testRemoveValidIdentifier() {
        System.out.println("removeValidIdentifier");
        String identifier = "";
        Address instance = new Address();
        instance.removeValidIdentifier(identifier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidIdentifier method, of class Address.
     */
    @Test
    public void testIsValidIdentifier() {
        System.out.println("isValidIdentifier");
        String identifier = "";
        Address instance = new Address();
        boolean expResult = false;
        boolean result = instance.isValidIdentifier(identifier);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormatCode method, of class Address.
     */
    @Test
    public void testSetFormatCode() throws Exception {
        System.out.println("setFormatCode");
        String fmtCode = "";
        String identifier = "";
        Address instance = new Address();
        instance.setFormatCode(fmtCode, identifier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormatCode method, of class Address.
     */
    @Test
    public void testGetFormatCode() throws Exception {
        System.out.println("getFormatCode");
        String fmtCode = "";
        Address instance = new Address();
        String expResult = "";
        String result = instance.getFormatCode(fmtCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFormatCode method, of class Address.
     */
    @Test
    public void testRemoveFormatCode() {
        System.out.println("removeFormatCode");
        String fmtCode = "";
        Address instance = new Address();
        instance.removeFormatCode(fmtCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
