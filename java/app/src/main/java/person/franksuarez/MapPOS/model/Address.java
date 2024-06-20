
package person.franksuarez.MapPOS.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import person.franksuarez.MapPOS.exception.InvalidIdentifier;

/** 
 *
 * @author franksuarez
 */
public class Address {
    // Philosophy:
    //  - Address content is what information is used.
    //  - Address format is how the information is structured to be displayed.
    //  - An address identifies a discrete location.
    //  - Identifying content in an address may be unique to a location.
    //  - Address content and format is often standardized.
    //  - Address content should be extractable and changable without affecting other content.
    //  - 
    
    /** 
     * 
     */
    String defaultValue;
    
    /** String of the country name.
     * 
     */
    String country;
    
    /** List of available identifiers.
     * 
     * 
     * 
     * NOTE: Could use reflection to get class properties.
     */
    List<String> validIdentifiers;
    
    /** Address data.
     * 
     * Validate against validIdentifiers.
     * 
     * 
     */
    HashMap<String,String> content;
    
    
    /** Map of format code to identifier.
     * 
     * Used with format method to create an address String.
     * 
     */
    HashMap<String,String> identifierFormatCodes;
    
    
    public Address() {
        this.content = new HashMap<>();
        this.country = "";
        this.defaultValue = "";
        this.identifierFormatCodes = new HashMap<>();
        this.validIdentifiers = new ArrayList<>();
    }
    
    
    
    /** Returns a String using the format String fmt.
     * 
     * @param fmt Format String
     * @return Formatted String
     */
    public String format(String fmtString) {
        String output = fmtString;
        
        for (String fmtCode: this.identifierFormatCodes.keySet()) {
            String identifier = this.identifierFormatCodes.get(fmtCode);
            String value = this.content.get(identifier);
            
            output = output.replaceAll(fmtCode, value);
        }
        
        return output;
    }
    
    /**
     *
     * @param identifier
     * @return
     * @throws InvalidIdentifier
     */
    public String getContent(String identifier) throws InvalidIdentifier {
        String output;

        // validate identifier
        if (!this.validIdentifiers.contains(identifier)) {
            // throw invalid identifier error
            throw new InvalidIdentifier();
        } 
        
        if (this.content.containsKey(identifier)) {
            output = this.content.get(identifier);
        } else {
            output = this.defaultValue;
        }
        
        return output;
    }
    
    /**
     * 
     * @param identifier
     * @param value
     * @throws InvalidIdentifier 
     */
    public void setContent(String identifier, String value) throws InvalidIdentifier {
        if (!this.validIdentifiers.contains(identifier)) {
            throw new InvalidIdentifier();
        }
        
        this.content.put(identifier, value);
    }
    
    
    public void addValidIdentifier(String identifier) {
        this.validIdentifiers.add(identifier);
    }
     
    public void removeValidIdentifier(String identifier) {
        // validate identifier
        
        this.validIdentifiers.remove(identifier);
        
    }
    
    
    public void setFormatCodeIdentifier(String fmtCode, String identifier) {
        // validate identifier
        
        this.identifierFormatCodes.put(fmtCode, identifier);
    }
    
    public String getFormatCodeIdentifier(String fmtCode) {
        // validate identifier
        
        
        return this.identifierFormatCodes.get(fmtCode);
    }
    
    
    
    
}
