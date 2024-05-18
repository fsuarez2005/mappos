package person.franksuarez.MapPOS.model;

import person.franksuarez.MapPOS.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class Product {
    public String name;
    public String description;
    private double price;
    private double cost;
    private int vendorId;
    private String upcString; // UPCA class

    // minimum size needed for storage or display
    private int boundBox;
    
    
    private UPCA upc;
    
    public Product() {
        this.upc = new UPCA();
    }
    
    
    public static Product create() {
        return new Product();
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Product setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public int getVendorId() {
        return vendorId;
    }

    public Product setVendorId(int vendorId) {
        this.vendorId = vendorId;
        return this;
    }
    
    
    
    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price must be non-negative.");
        }        
        
        this.price = price;
        
        return this;
    }
    
    public Product setUPC(String upcString) throws InvalidFormat {
        this.upc = new UPCA();
        this.upc.setDataAndValidate(upcString);
        return this;
    }
    
    @Override
    public String toString() {
        
        return String.format(
                "%10s %15s %.2f",
                name,
                upcString,
                price
                
        );
    }
    
}
