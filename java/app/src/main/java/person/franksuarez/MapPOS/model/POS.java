/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.List;

/** 
 * Point of Sale class.
 * 
 * 
 * @author franksuarez
 */
public class POS {
    // 
    private Transaction current;
    private POSState state;
    
    
    
    
    // list of transaction on this local unit
    // could have multiple active, but must select which Transaction
    private List<Transaction> transactions;
    
    
    public POS() {}
    
    public void initialize() {
        
    }
    
    
    
    
    
    
    
    public void appendProductToTransaction(Product p) {
        
        
    }
    
    
    
    
    
}
