/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class SQLiteDatabaseTest {
    private static final Logger LOG = Logger.getLogger(SQLiteDatabaseTest.class.getName());
    
    
    private final String tempDb = "/tmp/mappos_test_sqlite.db"; 
    private SQLiteDatabase db;
    
    
    public SQLiteDatabaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.db = new SQLiteDatabase(Paths.get(this.tempDb));
        
        
    }
    
    @AfterEach
    public void tearDown() {
    }


    
    @Test
    public void testInitialize() {
        System.out.println("test");
        this.db.initialize();
        assertTrue(this.db.path.toFile().exists());
    }

    /**
     * Test of deleteDBFile method, of class SQLiteDatabase.
     */
    @Test
    public void testDeleteDBFile() throws IOException, Exception {
        System.out.println("deleteDBFile");
        // create test file
        String filename = "/tmp/mappos_test_sqlite.db";
        
        File f = new File(filename);
        f.createNewFile();
        assertTrue(f.exists());
        
        
        SQLiteDatabase instance = new SQLiteDatabase(Path.of(filename));
        instance.deleteDBFile();
        
        
        assertFalse(instance.path.toFile().exists());
    }

    /**
     * Test of buildConnectionString method, of class SQLiteDatabase.
     */
    @Test
    public void testBuildConnectionString() {
        System.out.println("buildConnectionString");
        String driver = "sqlite";
        String name = "/tmp/testfile";
        String connectionString = "jdbc:"+driver+":"+Path.of(name).toString();
        LOG.info("expected connection string: "+connectionString);
        
        SQLiteDatabase instance = new SQLiteDatabase(Path.of(name));
        
        
        
        String output = instance.buildConnectionString();
        LOG.info("output connection string: "+output);
        
        
        assertEquals(connectionString,output);
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of open method, of class SQLiteDatabase.
     */
    @Disabled
    @Test
    public void testOpen() throws Exception {
        System.out.println("open");
        SQLiteDatabase instance = new SQLiteDatabase();
        instance.open();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
