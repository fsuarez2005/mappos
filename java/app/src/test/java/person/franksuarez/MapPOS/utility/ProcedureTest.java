/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.utility;

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
public class ProcedureTest {
    
    public ProcedureTest() {
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
     * Test of run method, of class Procedure.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Procedure instance = new ProcedureImpl();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of andThen method, of class Procedure.
     */
    @Test
    public void testAndThen() {
        System.out.println("andThen");
        Procedure after = null;
        Procedure instance = new ProcedureImpl();
        Procedure expResult = null;
        Procedure result = instance.andThen(after);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compose method, of class Procedure.
     */
    @Test
    public void testCompose() {
        System.out.println("compose");
        Procedure before = null;
        Procedure instance = new ProcedureImpl();
        Procedure expResult = null;
        Procedure result = instance.compose(before);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ProcedureImpl implements Procedure {

        public void run() {
        }
    }
    
}
