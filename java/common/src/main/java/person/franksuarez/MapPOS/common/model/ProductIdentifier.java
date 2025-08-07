// TODO: header
package person.franksuarez.MapPOS.common.model;

import java.util.function.Predicate;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/**
 * ProductIdentifier contains useful utility functions.
 *
 * @author franksuarez
 */
public abstract class ProductIdentifier {
    protected boolean hasCheckDigit;
    
    // should be a very generic type
    protected char[] data;
    protected int formatLength = 0;
    protected int checkDigitIndex;
    
    public abstract boolean isCharValid(char c);
    
    

    public boolean getHasCheckDigit() {
        return hasCheckDigit;
    }

    public void setHasCheckDigit(boolean hasCheckDigit) {
        this.hasCheckDigit = hasCheckDigit;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public int getFormatLength() {
        return formatLength;
    }

    public void setFormatLength(int formatLength) {
        if (formatLength < 0) {
            throw new IllegalArgumentException("Format Length cannot be negative.");
        }
        
        
        this.formatLength = formatLength;
    }

    public int getCheckDigitIndex() {
        return checkDigitIndex;
    }

    public void setCheckDigitIndex(int checkDigitIndex) {
        this.checkDigitIndex = checkDigitIndex;
    }

    /**
     * Checks each Char of charData to see if it passes isCharValidOld(char).
     *
     *
     * @return
     */
    public boolean areAllCharsValid() {
        boolean allValid = true;

        for (char c : this.data) {
            
            /*
            if (!isCharValidOld.test(c)) {
                return false;
            }*/
            
            if (! isCharValid(c)) {
                return false;
            }
        }

        return allValid;
    }
    
    public boolean isValid() {
        return isCorrectFormatLength() && areAllCharsValid();
    }
    
    public boolean isCorrectFormatLength() {
        return (this.data.length == this.formatLength);
    }

    public void fromString(String dataStr) {
        this.data = dataStr.toCharArray();
    }

    public int[] toIntArray() throws InvalidFormat, NullPointerException {
        if (this.data == null) {
            throw new NullPointerException();
        }

        int[] intData = new int[this.data.length];

        for (int n = 0; n < this.data.length; n++) {
            int intDigit = Character.getNumericValue(this.data[n]);

            if (intDigit == -1) {
                // Character.getNumericValue returns -1 on unaccepted char
                throw new InvalidFormat();
            }

            intData[n] = intDigit;
        }

        return intData;

    }

    /**
     *
     * @return The UPC as a list of the digits.
     */
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }

}
