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

/**
 *
 * @author franksuarez
 */
public class PLUListTest {
    
    public PLUListTest() {
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
     * Test of put method, of class PLUList.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        int pluNumber = 4011;
        String pluName = "Banana";
        PLUList instance = new PLUList();
        instance.put(pluNumber, pluName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PLUList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int pluNumber = 0;
        PLUList instance = new PLUList();
        instance.remove(pluNumber);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadFromCSVResource method, of class PLUList.
     */
    @Test
    public void testLoadFromCSVResource() throws Exception {
        System.out.println("loadFromCSVResource");
        String resName = "plu.csv";
        PLUList instance = new PLUList();
        instance.loadFromCSVResource(resName);
        
        System.out.printf("%s%n",instance);
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class PLUList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int pluNumber = 0;
        PLUList instance = new PLUList();
        String expResult = "";
        String result = instance.get(pluNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PLUList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PLUList instance = new PLUList();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
