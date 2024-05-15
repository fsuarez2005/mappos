/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.franksuarez.MapPOS.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class TransactionTest {
    private List<Product> products = new ArrayList<>() {
        {
            Product p1 = new Product();
            p1.name = "Pepsi";
            p1.description = "Soft drink";
            p1.setPrice(2.49);
            try {
                p1.setUPC("012345678901");
            } catch (InvalidFormat ex) {
                Logger.getLogger(TransactionTest.class.getName()).log(Level.SEVERE, null, ex);
                fail("Invalid format");
            }
            add(p1);
            
            
            Product p2 = new Product();
            p2.name = "Coke";
            p2.description = "Soft drink";
            p2.setPrice(3.10);
            add(p2);
            
            Product p3 = new Product();
            p3.name = "Sprite";
            p3.description = "Clear soft drink";
            p3.setPrice(1.99);
            add(p3);
        }

        private void fail(String invalid_format) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
    
    
    private Product testProduct1;
    private Product testProduct2;
    
    
    
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
        testProduct1 = new Product();
        testProduct1.setPrice(1.00);
        
        testProduct2 = new Product();
        testProduct2.setPrice(3.00);
        
        
        
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
        Product p = products.get(0);
        Transaction instance = new Transaction();
        instance.addEntry(p);
    }

    /**
     * Test of removeEntry method, of class Transaction.
     */
    @Test
    public void testRemoveEntry() {
        System.out.println("removeEntry");
        int index = 0;
        Transaction instance = new Transaction();
        
        instance.addEntry(products.get(index));
        
        instance.removeEntry(index);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEntry method, of class Transaction.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        int index = 0;
        Transaction instance = new Transaction();
        instance.addEntry(products.get(index));
        Product expResult = products.get(index);
        Product result = instance.getEntry(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Transaction.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Transaction instance = new Transaction();
        instance.addEntry(products.get(0));
        instance.addEntry(products.get(0));
        
        double expResult = 4.00;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPrintEntryList() {
        Transaction instance = new Transaction();
        instance.addEntry(products.get(0));
        instance.addEntry(products.get(1));
        instance.addEntry(products.get(0));
        instance.addEntry(products.get(2));
        instance.addEntry(products.get(0));
        instance.printEntryList();
    }
}
