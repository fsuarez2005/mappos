/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class SQLiteDatabaseTest {
    private String tempDb = "/tmp/mappos_test_sqlite.db"; 
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
    public void testOpen() throws IOException {
        //System.out.printf("");
        
        
    }
    
    @Test
    public void testInitialize() {
        System.out.println("test");
        this.db.initialize();
        
    }
    
    
}
