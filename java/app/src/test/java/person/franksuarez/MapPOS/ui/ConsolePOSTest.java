/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.ui;

import java.util.List;
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
public class ConsolePOSTest {
    
    public ConsolePOSTest() {
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
     * Test of main method, of class ConsolePOS.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        ConsolePOS.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrompt method, of class ConsolePOS.
     */
    @Test
    public void testGetPrompt() {
        System.out.println("getPrompt");
        ConsolePOS instance = new ConsolePOS();
        String expResult = "";
        String result = instance.getPrompt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrompt method, of class ConsolePOS.
     */
    @Test
    public void testSetPrompt() {
        System.out.println("setPrompt");
        String prompt = "";
        ConsolePOS instance = new ConsolePOS();
        instance.setPrompt(prompt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialize method, of class ConsolePOS.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        ConsolePOS instance = new ConsolePOS();
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readLine method, of class ConsolePOS.
     */
    @Test
    public void testReadLine() {
        System.out.println("readLine");
        ConsolePOS instance = new ConsolePOS();
        String expResult = "";
        String result = instance.readLine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printf method, of class ConsolePOS.
     */
    @Test
    public void testPrintf() {
        System.out.println("printf");
        String s = "";
        Object[] args = null;
        ConsolePOS instance = new ConsolePOS();
        instance.printf(s, args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tokenize method, of class ConsolePOS.
     */
    @Test
    public void testTokenize() {
        System.out.println("tokenize");
        String source = "";
        ConsolePOS instance = new ConsolePOS();
        List<String> expResult = null;
        List<String> result = instance.tokenize(source);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluateToken method, of class ConsolePOS.
     */
    @Test
    public void testEvaluateToken() {
        System.out.println("evaluateToken");
        String token = "";
        ConsolePOS instance = new ConsolePOS();
        instance.evaluateToken(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCommands method, of class ConsolePOS.
     */
    @Test
    public void testCreateCommands() {
        System.out.println("createCommands");
        ConsolePOS instance = new ConsolePOS();
        instance.createCommands();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class ConsolePOS.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        ConsolePOS instance = new ConsolePOS();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
