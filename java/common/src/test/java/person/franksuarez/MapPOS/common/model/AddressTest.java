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
import person.franksuarez.MapPOS.common.exception.InvalidFormatCode;
import person.franksuarez.MapPOS.common.exception.InvalidIdentifier;

/**
 *
 * @author franksuarez
 */
public class AddressTest {

    public static Address createGoodAddress1() {
        Address goodAddress1 = new Address();

        try {

            // create identifiers
            goodAddress1 = new Address();
            goodAddress1.addValidIdentifier("name");
            goodAddress1.addValidIdentifier("street");
            goodAddress1.addValidIdentifier("city");
            goodAddress1.addValidIdentifier("state");
            goodAddress1.addValidIdentifier("zipcode");

            // create format codes
            goodAddress1.setFormatCode("n", "name");
            goodAddress1.setFormatCode("s", "street");
            goodAddress1.setFormatCode("c", "city");
            goodAddress1.setFormatCode("t", "state");
            goodAddress1.setFormatCode("z", "zipcode");

            // add data
            goodAddress1.setContent("name", "John Doe");
            goodAddress1.setContent("street", "123 Fake St.");
            goodAddress1.setContent("city", "Port Huron");
            goodAddress1.setContent("state", "MI");
            goodAddress1.setContent("zipcode", "48060");

        } catch (InvalidIdentifier ex) {
            System.getLogger(AddressTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return goodAddress1;
    }

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
     * COMPLETE
     */
    @Test
    public void testFormat() {
        System.out.println("format");

        String fmtString = "%n %s";
        String expected = "John Doe 123 Fake St.";

        Address a = AddressTest.createGoodAddress1();

        assertEquals(expected, a.format(fmtString));
    }

    /**
     * COMPLETE
     */
    @Test
    public void testGetContent() throws Exception {
        System.out.println("getContent");
        String expected = "John Doe";
        
        Address a = AddressTest.createGoodAddress1();

        assertEquals(expected, a.getContent("name"));
    }

    /**
     * COMPLETE
     *
     */
    @Test
    public void testSetContent() throws InvalidIdentifier {
        System.out.println("setContent");
        String identifier = "name";
        String value = "Frank Suarez";
        //Address instance = new Address();
        Address instance = AddressTest.createGoodAddress1();

        assertDoesNotThrow(() -> {
            instance.setContent(identifier, value);
        });

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

    /**
     *
     *
     *
     * COMPLETE
     */
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

    /**
     *
     *
     * COMPLETE
     *
     * @throws InvalidIdentifier
     */
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
     *
     *
     *
     * COMPLETE
     *
     * @throws person.franksuarez.MapPOS.common.exception.InvalidIdentifier
     */
    @Test
    public void testRemoveValidIdentifier() {
        System.out.println("removeValidIdentifier");
        Address a = AddressTest.createGoodAddress1();

        assertDoesNotThrow(() -> {
            a.removeValidIdentifier("name");
        });
    }

    /**
     * COMPLETE
     */
    @Test
    public void fail_testRemoveValidIdentifier() {
        System.out.println("removeValidIdentifier");
        Address a = AddressTest.createGoodAddress1();

        InvalidIdentifier ex = assertThrows(InvalidIdentifier.class, () -> {
            a.removeValidIdentifier("invalid");
        });
    }

    /**
     * TODO Test of isValidIdentifier method, of class Address.
     *
     *
     *
     */
    @Test
    public void testIsValidIdentifier() {
        System.out.println("testIsValidIdentifier");
        Address a = AddressTest.createGoodAddress1();

        assertTrue(a.isValidIdentifier("name"));

    }

    /**
     * TODO Test of setFormatCode method, of class Address.
     */
    @Test
    public void testSetFormatCode() throws Exception {
        System.out.println("setFormatCode");
        Address a = AddressTest.createGoodAddress1();

        assertDoesNotThrow(() -> {
            a.setFormatCode("n", "name");
        });

    }

    /**
     * TODO Test of getFormatCode method, of class Address.
     */
    @Test
    public void testGetFormatCode() {
        System.out.println("getFormatCode");
        String fmtCode = "n";
        Address instance = AddressTest.createGoodAddress1();
        
        assertDoesNotThrow(() -> {
            instance.removeFormatCode(fmtCode);
        });
    }

    /**
     * TODO Test of removeFormatCode method, of class Address.
     */
    @Test
    public void testRemoveFormatCode() throws InvalidFormatCode {
        System.out.println("removeFormatCode");
        String fmtCode = "n";
        Address instance = AddressTest.createGoodAddress1();
        
        assertDoesNotThrow(() -> {
            instance.removeFormatCode(fmtCode);
        });
    }

    @Test
    public void fail_testRemoveFormatCode_empty() {
        System.out.println("removeFormatCode");
        String fmtCode = "";
        Address instance = AddressTest.createGoodAddress1();

        InvalidFormatCode ex = assertThrows(InvalidFormatCode.class, () -> {
            instance.removeFormatCode(fmtCode);
        });
        System.out.println(ex.getMessage());
    }

    @Test
    public void fail_testRemoveFormatCode_notfound() {
        System.out.println("removeFormatCode");
        String fmtCode = "notfound";
        Address instance = AddressTest.createGoodAddress1();

        InvalidFormatCode ex = assertThrows(InvalidFormatCode.class, () -> {
            instance.removeFormatCode(fmtCode);
        });

        System.out.println(ex.getMessage());
    }

}
