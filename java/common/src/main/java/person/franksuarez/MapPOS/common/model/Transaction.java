// TODO: header

package person.franksuarez.MapPOS.common.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franksuarez
 */
public class Transaction implements java.io.Serializable {
    // date
    
    // time
    ZonedDateTime datetime;
    
    private double taxPercentage = 6.0;
    private List<Product> entries;
    
    public Transaction() {
        this.entries = new ArrayList<>();
        
        
        // TODO: make timezone configurable
        this.datetime = ZonedDateTime.now(ZoneId.of("America/Detroit"));
    }
    
    // TODO: switch parameter to (Transaction.Entry x)
    public void add(Product p) {
        this.entries.add(p);
    }
    
    public void remove(int index) {
        this.entries.remove(index);
    }
    
    public Product get(int index) {
        return this.entries.get(index);
    }
    
    public List<Product> getAll() {
        return this.entries;
    }
    
    public double getSubTotal() {
        double total = 0.0;
        
        for (Product p: entries) {
            total += p.getPrice();
        }
        
        return total;
    }

    public void setTaxPercentage(double taxPercentage) {
        // TODO: guard
        
        this.taxPercentage = taxPercentage;
    }
    
    public double getTaxPercentage() {
        return taxPercentage;
    }
    
    public double getTotal() {
        double total = getSubTotal();
        double taxAdjuster = (100+getTaxPercentage())/100;
        
        total *= taxAdjuster;
        
        return total;
    }
}
