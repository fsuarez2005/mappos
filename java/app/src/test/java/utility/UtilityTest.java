/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utility;

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
public class UtilityTest {
    
    public UtilityTest() {
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
     * Test of convertStringToByteArray method, of class Utility.
     */
    @Test
    public void testConvertStringToByteArray() {
        System.out.println("convertStringToByteArray");
        String numStr = "01234567890";
        byte[] expResult = new byte[] {0,1,2,3,4,5,6,7,8,9,0};
        byte[] result = Utility.convertStringToByteArray(numStr);
        assertArrayEquals(expResult, result);
    }
    
}
