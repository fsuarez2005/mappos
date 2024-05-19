/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.ArrayList;
import java.util.List;

/** 
 * Point of Sale class.
 * 
 * 
 * @author franksuarez
 */
public class POS {
    private POSState state;
    
    
    private Transaction current;
    // list of transaction on this local unit
    // could have multiple active, but must select which Transaction
    private List<Transaction> transactions;
    
    
    public POS() {}
    
    
    public void startTransaction() {
        this.current = new Transaction();   
    }
    
    public void endTransaction() {
        this.current = null;
    }
    
    
    
    
    public void initialize() {
        this.transactions = new ArrayList<>();
    }
    
    
    
    
    
    
    
    public void appendProductToTransaction(Product p) {
        if (this.current == null) {
            throw new NullPointerException();
        }
        
        this.current.addEntry(p);
        
        
        
    }
    
    
    
    
    
}
