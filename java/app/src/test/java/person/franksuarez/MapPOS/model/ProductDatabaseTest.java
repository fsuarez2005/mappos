/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ProductDatabaseTest {
    
    public ProductDatabaseTest() {
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
     * Test of buildConnectionString method, of class ProductDatabase.
     */
    @Test
    public void testBuildConnectionString() {
        System.out.println("buildConnectionString");
        String location = "abcdefg";
        ProductDatabase instance = new ProductDatabase();
        String expResult = "";
        String result = instance.buildConnectionString(location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connect method, of class ProductDatabase.
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        String location = "";
        ProductDatabase instance = new ProductDatabase();
        instance.connect(location);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class ProductDatabase.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        ProductDatabase instance = new ProductDatabase();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testConnection method, of class ProductDatabase.
     */
    @Test
    public void testTestConnection() {
        System.out.println("testConnection");
        ProductDatabase instance = new ProductDatabase();
        instance.testConnection();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of initializeDatabase method, of class ProductDatabase.
     */
    @Test
    public void testInitializeDatabase() {
        try {
            System.out.println("initializeDatabase");
            ProductDatabase instance = new ProductDatabase();
            instance.connect("test.db");
            instance.initializeDatabase();
            
            
            instance.close();
            
            // TODO review the generated test code and remove the default call to fail.
            //fail("The test case is a prototype.");
        } catch (SQLException ex) {
            fail("SQLException");
            Logger.getLogger(ProductDatabaseTest.class.getName()).log(Level.SEVERE, ex.getSQLState(), ex);
        }
    }

    
}
