/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.utility;

import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.exception.InvalidFormat;
import person.franksuarez.MapPOS.model.Product;

/**
 *
 * @author franksuarez
 */
public class TestData {
    public final static String goodUPCA = "012000173226";
    public final static String shortUPCA = "012000";
    public final static String badCheckUPCA = "012000173220";
    public final static String hasCharUPCA = "012000A73226";
    public final static int[] intDataUPCA = new int[] {
        0,1,2,0,0,0,1,7,3,2,2,6
    };
    
    public final static char[] charDataUPCA = goodUPCA.toCharArray();
    
    
    
    public final static Product product1 = new Product() {
        {
            setName("Coke");
            setDescription("A refreshing drink.");
            setCost(0.01);
            setPrice(2.99);
            try {
                setUPC(TestData.goodUPCA);
            } catch (InvalidFormat ex) {
                Logger.getLogger(TestData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    
    public final static Product product2 = new Product() {
        {
            setName("Pepsi");
            setDescription("An okay drink.");
            setCost(0.01);
            setPrice(1.00);
            try {
                setUPC("123");
            } catch (InvalidFormat ex) {
                Logger.getLogger(TestData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    

    
    
    
    
}
