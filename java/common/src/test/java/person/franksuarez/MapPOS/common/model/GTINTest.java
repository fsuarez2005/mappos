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
import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class GTINTest {

    public GTINTest() {
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
     * Test of generalCalculateCheckDigit method, of class GTIN.
     */
    @Test
    public void testGeneralCalculateCheckDigit() throws InvalidFormat {
        System.out.println("generalCalculateCheckDigit");

        String upc = "012000130311";
        char[] upcCharArray = upc.toCharArray();

        GTIN instance = new GTIN();

        instance.data = upcCharArray;

        int expResult = 1;
        int result = instance.calculateCheckDigit();

        assertEquals(expResult, result);
    }
}
