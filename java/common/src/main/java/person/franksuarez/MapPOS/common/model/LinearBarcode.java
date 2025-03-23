// TODO: header
package person.franksuarez.MapPOS.common.model;

import java.util.Optional;
import java.util.function.Predicate;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/**
 * LinearBarcode contains useful utility functions.
 *
 * @author franksuarez
 */
public class LinearBarcode {

    protected boolean hasCheckDigit;
    protected char[] data;

    protected int formatLength = 0;

    transient protected Predicate<Character> isCharValid;

    /**
     * Checks each Char of charData to see if it passes isCharValid(char).
     *
     *
     * @return
     */
    public boolean areAllCharsValid() {
        
        
       
        
        
        boolean allValid = true;

        for (char c : this.data) {
            if (!isCharValid.test(c)) {
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

    
    // TODO: replace with isCharValid Predicate
    public boolean hasOnlyDigits() {
        boolean output = true;
        for (int n = 0; n < this.data.length; n++) {
            if (!Character.isDigit(this.data[n])) {
                output = false;
                break;
            }
        }
        return output;
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
