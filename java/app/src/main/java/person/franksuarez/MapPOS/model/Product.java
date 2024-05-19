package person.franksuarez.MapPOS.model;

import org.checkerframework.framework.qual.IgnoreInWholeProgramInference;
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

    @Override
    public String toString() {

        return String.format(
                "%-40s %-15s %05.2f",
                name,
                this.upc.toString(),
                price
        );
    }

}
