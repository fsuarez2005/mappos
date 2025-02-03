// TODO: header

// TODO: Need to test and check for bugs.

package person.franksuarez.MapPOS.common.model;

import java.util.function.Predicate;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;

// TODO: implement serialization

/**
 *
 * @author franksuarez
 */
public class UPC extends GTIN implements java.io.Serializable {
    protected char[] charData; // some UPCs have non-numeral characters
    protected int[] intData; // many UPCs have only numeral characters. could be null.

    protected int formatLength = 0;
    protected boolean formatOnlyDigits = false;

    // TODO: causes problems for serialization. 
    transient protected Predicate<Character> isCharValid; // returns true if char is valid for this UPC

    //private boolean isValid = false;
    public UPC() {
        this.isCharValid = (Character c) -> true;
    }
    
    

    /**
     * 
     * 
     * 
     * 
     * 
     * @param data
     * @return 
     */
    public void setIntData(int[] data) {
        this.intData = data;
    }

    
    
    public int[] getIntData() {
        return this.intData;
    }

    public char[] getCharData() {
        return charData;
    }


    
    /**
     * 
     * @param charData
     * @return 
     */
    public void setCharData(char[] charData) {
        this.charData = charData;
    }

    public Predicate<Character> getIsCharValid() {
        return isCharValid;
    }

    public void setIsCharValid(Predicate<Character> isCharValid) {
        this.isCharValid = isCharValid;
    }

    public void setFormatLength(int formatLength) {
        // validate input
        
        this.formatLength = formatLength;
    }

    public int getFormatLength() {
        return this.formatLength;
    }

    // TODO: fromString: convert to static function
    public void fromString(String dataString) {
        this.setCharData(dataString.toCharArray());
    }

    // TODO: generateDigitOnlyData: convert to utility function
    public int[] generateDigitOnlyData() throws InvalidFormat {
        if (this.charData == null) {
            throw new NullPointerException();
        }

        this.intData = new int[this.charData.length];

        for (int n = 0; n < this.charData.length; n++) {
            int intDigit = Character.getNumericValue(this.charData[n]);
            
            if (intDigit == -1) {
                // Character.getNumericValue returns -1 on unaccepted char
                
                throw new InvalidFormat();
            }
            
            this.intData[n] = intDigit;
        }
        
        return this.intData;        
    }

    // TODO: hasOnlyDigits: convert to utility function
    public boolean hasOnlyDigits() {
        boolean output = true;
        for (int n = 0; n < this.charData.length; n++) {
            if (! Character.isDigit(this.charData[n])) {
                output = false;
                break;
            }
        }

        return output;
    }
    
    
    /** Checks each Char of charData to see if it passes isCharValid(char).
     *
     *
     * @return
     */
    public boolean areAllCharsValid() {
        boolean allValid = true;

        for (char c : charData) {
            if (!isCharValid.test(c)) {
                return false;
            }
        }

        return allValid;
    }

    @Override
    public boolean isValid() {
        return isCorrectFormatLength() && areAllCharsValid();
    }
    
    public boolean isCorrectFormatLength() {
        return (this.charData.length == this.formatLength);
    }
    
    /**
     *
     * @return The UPC as a list of the digits.
     */
    @Override
    public String toString() {
        return String.valueOf(this.charData);
    }
    
    
    
    public void generalCalculateCheckDigit() {
        
        
        
    }

}
