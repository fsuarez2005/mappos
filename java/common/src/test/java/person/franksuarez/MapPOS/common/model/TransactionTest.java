/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.List;
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

    @Test
    public void testZoneId() {
        Instant now = Instant.now();
        System.out.printf("Now: %s%n",now.toString());
        System.out.printf("Detroit: %s%n", now.atZone(ZoneId.of("America/Detroit")));
        //System.out.printf("Day of Year: %d%n",now.get(ChronoField.HOUR_OF_DAY));
        
        ZonedDateTime zoned_now = ZonedDateTime.now();
        System.out.printf(
                "Date: %d/%d/%d Time: %d:%02d:%02d%n",
                zoned_now.getMonthValue(),
                zoned_now.getDayOfMonth(),
                zoned_now.getYear(),
                zoned_now.getHour(),
                zoned_now.getMinute(),
                zoned_now.getSecond()
                
                );
        
        
        
        
    }
    
    
    
    
    /**
     * Test of add method, of class Transaction.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Product p = null;
        Transaction instance = new Transaction();
        instance.add(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Transaction.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        Transaction instance = new Transaction();
        instance.remove(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Transaction.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        Transaction instance = new Transaction();
        Product expResult = null;
        Product result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Transaction.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        Transaction instance = new Transaction();
        List<Product> expResult = null;
        List<Product> result = instance.getAll();
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
     * Test of setTaxPercentage method, of class Transaction.
     */
    @Test
    public void testSetTaxPercentage() {
        System.out.println("setTaxPercentage");
        double taxPercentage = 0.0;
        Transaction instance = new Transaction();
        instance.setTaxPercentage(taxPercentage);
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

    /**
     * Test of getTotal method, of class Transaction.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Transaction instance = new Transaction();
        double expResult = 0.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    
}
