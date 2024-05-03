/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franksuarez
 */
public class Transaction {
    private List<Product> products;
    
   
    
    public Transaction() {
        this.products = new ArrayList<>();
    }
   
    
    public void appendProduct(Product p) {
        this.products.add(p);
        
    }
    
    public double getTotal() {
        double total = 0;
        
        for (Product p: products) {
            total += p.getPrice();
        }
        return total;
    }
    
    
    
    
}
