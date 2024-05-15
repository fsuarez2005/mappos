/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS;

import com.google.common.io.Resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franksuarez
 */
public class ResourceTest {
       
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
    public void testGetResource() {
        URL configPropertiesURL = Resources.getResource("config.properties");
        
        Properties configProperties = new Properties();
        
        try {
            configProperties.load(new FileInputStream(configPropertiesURL.getPath()));
            
            
            
            configProperties.list(System.out);
            
            String appName = (String) configProperties.get("name");
            
            
            System.out.printf("appName = %s%n",appName);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResourceTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResourceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    
}
