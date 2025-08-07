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
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class ProductIdentifierTest {
    private String testUPC1Str = "751746033615";
    
    public ProductIdentifier createTestObject() {
        ProductIdentifier data = new ProductIdentifier(testUPC1Str.toCharArray(), 12, true, false, 11){
            @Override
            public boolean isCharValid(char c) {
                return Character.isDigit(c);
            }
        };

        
        return data;
    }



    public ProductIdentifierTest() {
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
     * Test of isCharValid method, of class ProductIdentifier.
     */
    @Test
    public void testIsCharValid() {
        System.out.println("isCharValid");
        char c = '1';
        ProductIdentifier instance = createTestObject();
        boolean expResult = true;
        boolean result = instance.isCharValid(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHasCheckDigit method, of class ProductIdentifier.
     */
    @Test
    public void testGetHasCheckDigit() {
        System.out.println("getHasCheckDigit");
        ProductIdentifier instance = new ProductIdentifierImpl();
        boolean expResult = false;
        boolean result = instance.getHasCheckDigit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHasCheckDigit method, of class ProductIdentifier.
     */
    @Test
    public void testSetHasCheckDigit() {
        System.out.println("setHasCheckDigit");
        boolean hasCheckDigit = false;
        ProductIdentifier instance = new ProductIdentifierImpl();
        instance.setHasCheckDigit(hasCheckDigit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class ProductIdentifier.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        ProductIdentifier instance = new ProductIdentifierImpl();
        char[] expResult = null;
        char[] result = instance.getData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class ProductIdentifier.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        char[] data = null;
        ProductIdentifier instance = new ProductIdentifierImpl();
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormatLength method, of class ProductIdentifier.
     */
    @Test
    public void testGetFormatLength() {
        System.out.println("getFormatLength");
        ProductIdentifier instance = new ProductIdentifierImpl();
        int expResult = 0;
        int result = instance.getFormatLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormatLength method, of class ProductIdentifier.
     */
    @Test
    public void testSetFormatLength() {
        System.out.println("setFormatLength");
        
        ProductIdentifier instance = createTestObject();
        int formatLength = 0;
        assertDoesNotThrow(() -> {
            instance.setFormatLength(formatLength);
        });
        
        ProductIdentifier instance2 = createTestObject();
        
        int formatLength2 = -1;
        
        IllegalArgumentException assertThrows = assertThrows(IllegalArgumentException.class, () -> {
            instance2.setFormatLength(formatLength2);
        });
    }

    /**
     * Test of getCheckDigitIndex method, of class ProductIdentifier.
     */
    @Test
    public void testGetCheckDigitIndex() {
        System.out.println("getCheckDigitIndex");
        ProductIdentifier instance = new ProductIdentifierImpl();
        int expResult = 0;
        int result = instance.getCheckDigitIndex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCheckDigitIndex method, of class ProductIdentifier.
     */
    @Test
    public void testSetCheckDigitIndex() {
        System.out.println("setCheckDigitIndex");
        int checkDigitIndex = 0;
        //ProductIdentifier instance = new ProductIdentifierImpl();
        ProductIdentifier instance = createTestObject();
        
        assertDoesNotThrow(() -> {
            instance.setCheckDigitIndex(checkDigitIndex);
        });
    }
    
    @Test
    public void fail_testSetCheckDigitIndex() {
        
        
    
    }
    
    

    /**
     * Test of areAllCharsValid method, of class ProductIdentifier.
     */
    @Test
    public void testAreAllCharsValid() {
        System.out.println("areAllCharsValid");
        ProductIdentifier instance = new ProductIdentifierImpl();
        boolean expResult = false;
        boolean result = instance.areAllCharsValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invalidate method, of class ProductIdentifier.
     */
    @Test
    public void testInvalidate() {
        System.out.println("invalidate");
        ProductIdentifier instance = new ProductIdentifierImpl();
        instance.invalidate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class ProductIdentifier.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        ProductIdentifier instance = new ProductIdentifierImpl();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCorrectFormatLength method, of class ProductIdentifier.
     */
    @Test
    public void testIsCorrectFormatLength() {
        System.out.println("isCorrectFormatLength");
        ProductIdentifier instance = new ProductIdentifierImpl();
        boolean expResult = false;
        boolean result = instance.isCorrectFormatLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromString method, of class ProductIdentifier.
     */
    @Test
    public void testFromString() {
        System.out.println("fromString");
        String dataStr = "";
        ProductIdentifier instance = new ProductIdentifierImpl();
        instance.fromString(dataStr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toIntArray method, of class ProductIdentifier.
     */
    @Test
    public void testToIntArray() throws Exception {
        System.out.println("toIntArray");
        ProductIdentifier instance = new ProductIdentifierImpl();
        int[] expResult = null;
        int[] result = instance.toIntArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ProductIdentifier.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ProductIdentifier instance = new ProductIdentifierImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ProductIdentifierImpl extends ProductIdentifier {

        public boolean isCharValid(char c) {
            return false;
        }
    }

}
