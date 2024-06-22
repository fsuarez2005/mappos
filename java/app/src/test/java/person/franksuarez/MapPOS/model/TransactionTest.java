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
import person.franksuarez.MapPOS.utility.TestData;

/**
 *
 * @author franksuarez
 */
public class TransactionTest {

    public TransactionTest() {
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
     * Test of addEntry method, of class Transaction.
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        Product p = null;
        Transaction instance = new Transaction();
        instance.addEntry(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEntry method, of class Transaction.
     */
    @Test
    public void testRemoveEntry() {
        System.out.println("removeEntry");
        int index = 0;
        Transaction instance = new Transaction();
        instance.removeEntry(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntry method, of class Transaction.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        int index = 0;
        Transaction instance = new Transaction();
        Product expResult = null;
        Product result = instance.getEntry(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubTotal method, of class Transaction.
     */
    @Test
    public void testGetSubTotal() {
        System.out.println("getSubTotal");
        Transaction instance = new Transaction();
        double expResult = 0.0;
        double result = instance.getSubTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaxPercentage method, of class Transaction.
     */
    @Test
    public void testGetTaxPercentage() {
        System.out.println("getTaxPercentage");
        Transaction instance = new Transaction();
        double expResult = 0.0;
        double result = instance.getTaxPercentage();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTaxAdjustedTotal() {
        Transaction instance = new Transaction();

        System.out.printf("x = %f%n", ((100.0 + instance.getTaxPercentage()) / 100) * 100);

    }

    /**
     * Test of getTotal method, of class Transaction.
     */
    @Test
    public void testGetTotal() {
        

        System.out.println("getTotal");
        Transaction instance = new Transaction();

        Product p = new Product() {
                {
                    setName("test");
                    setPrice(1.00);
                }
        };
        
        
        System.out.printf("%s%n",p.toTupleString());
        instance.addEntry(p);

        double expResult = 1.06;
        double result = instance.getTotal();

        System.out.printf("Result = %f%n", result);
        System.out.printf("delta = %f%n", Math.abs(expResult - result));

        assertEquals(expResult, result, Product.DELTA);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printEntryList method, of class Transaction.
     */
    @Test
    public void testPrintEntryList() {
        System.out.println("printEntryList");
        Transaction instance = new Transaction();
        instance.printEntryList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
