package person.franksuarez.MapPOS.common.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import person.franksuarez.MapPOS.common.exception.InvalidFormatCode;
import person.franksuarez.MapPOS.common.exception.InvalidIdentifier;

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
    //  - Data structure should be flexible to allow for future changes.

    
    private String fmtCodePrefix = "%";
    
    
    /**
     *
     */
    private String defaultValue;

    /**
     * String of the country name.
     *
     */
    private String country;

    /**
     * List of available identifiers.
     *
     *
     *
     * NOTE: Could use reflection to get class properties.
     */
    //List<String> validIdentifiers;
    private Set<String> validIdentifiers;
    /**
     * Address data.
     *
     * Validate against validIdentifiers.
     *
     *
     */
    private HashMap<String, String> content;

    /**
     * Map of format code to identifier.
     *
     * Used with format method to create an address String.
     *
     */
    private HashMap<String, String> identifierFormatCodes;

    public Address() {
        this.content = new HashMap<>();
        this.country = "";
        this.defaultValue = "";
        this.identifierFormatCodes = new HashMap<>();
        this.validIdentifiers = new HashSet<>();
    }

    /**
     * Returns a String using the format String fmt.
     *
     * @param fmtString
     * @return Formatted String
     */
    public String format(String fmtString) {
        String output = fmtString;

        for (String fmtCode : this.identifierFormatCodes.keySet()) {
            String identifier = this.identifierFormatCodes.get(fmtCode);
            String value = this.content.get(identifier);

            
            output = output.replace(fmtCodePrefix+fmtCode, value != null ? value : "");

        }

        return output;
    }

    /**
     * Returns address content.
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
     * Sets address content.
     *
     * @param identifier
     * @param value
     * @throws InvalidIdentifier
     */
    public void setContent(String identifier, String value) throws InvalidIdentifier {
        if (! this.validIdentifiers.contains(identifier)) {
            throw new InvalidIdentifier();
        }
        
        this.content.put(identifier, value);
    }

    /**
     * Adds an identifier to the valid identifier list.
     *
     * @param identifier
     */
    public void addValidIdentifier(String identifier) throws InvalidIdentifier {
        if (identifier.isEmpty()) {
            throw new InvalidIdentifier("Identifier cannot be empty string.");
        }
        if (validIdentifiers.contains(identifier)) {
            throw new InvalidIdentifier("Identifier already exists.");
        }

        this.validIdentifiers.add(identifier);

    }

    /**
     * Removes an identifier from the valid identifier list.
     *
     * @param identifier
     */
    public void removeValidIdentifier(String identifier) throws InvalidIdentifier {
        if (!validIdentifiers.contains(identifier)) {
            throw new InvalidIdentifier(String.format("Identifier %s not found.", identifier));
        }

        validIdentifiers.remove(identifier);
    }

    /**
     * Returns true if identifier is valid for this address.
     *
     * @param identifier
     * @return
     */
    public boolean isValidIdentifier(String identifier) {
        return this.validIdentifiers.contains(identifier);
    }

    /**
     * Set the identifier String for the format code.
     *
     * @param fmtCode
     * @param identifier
     * @throws person.franksuarez.MapPOS.common.exception.InvalidIdentifier
     */
    public void setFormatCode(String fmtCode, String identifier) throws InvalidIdentifier {
        // validate identifier
        if (!isValidIdentifier(identifier)) {
            throw new InvalidIdentifier();
        }

        this.identifierFormatCodes.put(fmtCode, identifier);
    }

    /**
     * Returns the identifier String for the format code.
     *
     * @param fmtCode
     * @return
     * @throws person.franksuarez.MapPOS.exception.InvalidIdentifier
     */
    public String getFormatCode(String fmtCode) throws InvalidIdentifier {
        // Validate identifier
        // NOTE: An invalid identifier would return NULL otherwise.
        if (!this.identifierFormatCodes.containsKey(fmtCode)) {
            throw new InvalidIdentifier();
        }
        return this.identifierFormatCodes.get(fmtCode);
    }

    /**
     * Removes the format code.
     *
     * @param fmtCode
     */
    public void removeFormatCode(String fmtCode) throws InvalidFormatCode {
        if (fmtCode.isEmpty()) {
            throw new InvalidFormatCode("Format code cannot be empty.");
        }
        if (! identifierFormatCodes.containsKey(fmtCode)) {
            throw new InvalidFormatCode(String.format("Format code %s not found.",fmtCode));
        }
        
        
        this.identifierFormatCodes.remove(fmtCode);
    }

}
