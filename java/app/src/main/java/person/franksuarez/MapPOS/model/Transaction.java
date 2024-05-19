/**
 * 
 */
package person.franksuarez.MapPOS.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franksuarez
 */
public class Transaction {
    private double taxPercentage = 0.0;
    private List<Product> entries;
    
    public Transaction() {
        this.entries = new ArrayList<>();
    }
    
    public void addEntry(Product p) {
        this.entries.add(p);
    }
    
    public void removeEntry(int index) {
        this.entries.remove(index);
    }
    
    public Product getEntry(int index) {
        return this.entries.get(index);
    }
    
    public double getTotal() {
        double total = 0;
        
        for (Product p: entries) {
            total += p.getPrice();
        }
        return total;
    }
    
    public void printEntryList() {
        /*
        
        Coke                    0-12345-67890-1    2.99
        Coke                    0-12345-67890-1    2.99
        Coke                    0-12345-67890-1    2.99
        Coke                    0-12345-67890-1    2.99
        Subtotal  =  00.00
        Tax       =  00.00
        Total     =  00.00
        
        
        
        
        */
        
        
        
        
        
        System.out.println("Transaction:");
        for (Product p: this.entries) {
            System.out.printf("%s%n",p.toString());
        }
        
        double total = getTotal();
        System.out.printf("Subtotal  =  %.2f%n",total);
        System.out.printf("Tax       =  %.2f%n", total*0.06);
        System.out.printf("Total     =  %.2f%n", total*1.06);
    }
}
