/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

/**
 *
 * @author franksuarez
 */
public class Product {
    
    
    private String description;
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    
    // ==============================
    
    private UPCA upc;
    public UPCA getUpc() {
        return upc;
    }
    public void setUpc(UPCA upc) {
        this.upc = upc;
    }
    
    // ==============================
    private double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    
    // ==============================
    
    private double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
    public Product() {}
    
    

    
}
