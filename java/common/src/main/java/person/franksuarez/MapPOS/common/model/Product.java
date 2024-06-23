package person.franksuarez.MapPOS.common.model;

import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class Product {
    /** Delta used for price and cost so rounding is not used.
     *
     * Rounding may cause problems in the future.
     * 
     * 
     */
    public final static double DELTA = 0.005;
    
    private String name;
    private String description;
    private double price;
    private double cost;
    private int vendorId;

    // minimum size needed for storage or display
    private int boundBox;

    private UPCA upc;

    public Product() {
        this.upc = new UPCA();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price must be non-negative.");
        }
        this.price = price;
    }

    public void setUPC(String upcString) throws InvalidFormat {
        this.upc = new UPCA();
        //this.upc.setDataAndValidate(upcString);

        this.upc.fromString(upcString);
    }

    public String toTupleString() {
        String output = String.format("(%s,%f,%f)",this.name,this.price,this.cost);
        return output;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
