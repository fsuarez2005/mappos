// TODO: header

// TODO: Need to test and check for bugs.


package person.franksuarez.MapPOS.common.model;

import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class UPCA extends GTIN implements java.io.Serializable {

    private int checkDigitIndex;

    public UPCA() {
        this.formatLength = 12;
        this.checkDigitIndex = 11;
        
        // only digits are valid
        this.isCharValid = (Character c) -> {
            return (Character.isDigit(c));
        };
    }
    
    /** Returns true if the check digit is correct.
     *
     * @return True if UPC has a good check digit.
     * @throws person.franksuarez.MapPOS.common.exception.InvalidFormat
     */
    public boolean hasValidCheckDigit() throws InvalidFormat {
        int[] intData = this.toIntArray();
        
        
        if (intData == null) {
            throw new NullPointerException();
        }
        if (intData.length < formatLength) {
            throw new InvalidFormat();
        }

        return (intData[checkDigitIndex] == calculateCheckDigit());
    }
}
