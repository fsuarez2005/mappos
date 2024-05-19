/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import person.franksuarez.MapPOS.utility.TestData;

/**
 *
 * @author franksuarez
 */
public class POSTest {
    
    public POSTest() {
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
     * Test of startTransaction method, of class POS.
     */
    @Test
    public void testStartTransaction() {
        System.out.println("startTransaction");
        POS instance = new POS();
        instance.startTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endTransaction method, of class POS.
     */
    @Test
    public void testEndTransaction() {
        System.out.println("endTransaction");
        POS instance = new POS();
        instance.endTransaction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentTransaction method, of class POS.
     */
    @Test
    public void testGetCurrentTransaction() {
        System.out.println("getCurrentTransaction");
        POS instance = new POS();
        
        //Product product1 = TestData.product1;
        
        instance.startTransaction();
        
        for (int n = 0; n < 5; n++) {
            
            instance.getCurrentTransaction().addEntry(TestData.product1);
        }
        
        
        instance.getCurrentTransaction().printEntryList();
        
        instance.endTransaction();
        
        
    }

    /**
     * Test of setCurrentTransaction method, of class POS.
     */
    @Test
    public void testSetCurrentTransaction() {
        System.out.println("setCurrentTransaction");
        Transaction currentTransaction = null;
        POS instance = new POS();
        instance.setCurrentTransaction(currentTransaction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
