/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.common.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import person.franksuarez.MapPOS.common.exception.InvalidAttribute;

/** Adds functionality to Object.
 *
 * @author franksuarez
 */
public class Thing {
    // 
    private HashMap<String,String> attributes;
    private List<String> validAttributes;
    
    public Thing() {
        this.attributes = new HashMap<>();
        this.validAttributes = new ArrayList<>();
    }
    
    public void setAttribute(String name, String value) throws InvalidAttribute {
        if (! this.isValidAttribute(name)) {
            throw new InvalidAttribute();
        }
        
        this.attributes.put(name,value);
    }
    
    public String getAttribute(String name) throws InvalidAttribute {
        if (! this.isValidAttribute(name)) {
            throw new InvalidAttribute();
        }
        return this.attributes.get(name);
    }
    
    public void addValidAttribute(String name) {
        this.validAttributes.add(name);
    }
    
    public void removeValidAttribute(String name) {
        this.validAttributes.remove(name);
        
    }
    
    public boolean isValidAttribute(String name) {
        return this.validAttributes.contains(name);
    }
}
