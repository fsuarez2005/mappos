/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.nio.file.Path;
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
public class DatabaseTest {
    private Database d;
    
    
    public DatabaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.d = new Database();
        this.d.setPath(Path.of("/hi"));
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setPath method, of class Database.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        Path path = null;
        Database instance = new Database();
        instance.setPath(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class Database.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Database instance = new Database();
        Path expResult = null;
        Path result = instance.getPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnectionString method, of class Database.
     */
    @Test
    public void testGetConnectionString() {
        System.out.println("getConnectionString");
        //Database instance = new Database();
        //String expResult = "";
        //String result = instance.getConnectionString();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of open method, of class Database.
     */
    @Test
    public void testOpen() throws Exception {
        System.out.println("open");
        Database instance = new Database();
        instance.open();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
