// TODO: header
package person.franksuarez.MapPOS.common.model;

import java.util.List;

/**
 *
 * @author franksuarez
 */
public class Product implements java.io.Serializable {
    private String name;
    private String description;
    private double price;
    private double cost;
    private int currency_code;
    
    private String category;
    private String brand;
    private List<String> tags;
    
    private double weight;
    private double height;
    private double width;
    private double depth;
           
    private UPCA upc;


}
