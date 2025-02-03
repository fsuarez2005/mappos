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

    /**
     * TODO: move to GTIN and generalize
     * 
     * @return Check digit for the UPC.
     * @throws person.franksuarez.MapPOS.common.exception.InvalidFormat
     */
    public int calculateCheckDigit() throws InvalidFormat {
        
        if (! this.isValid()) {
            throw new InvalidFormat();
        }
        
        


        int[] intData = this.toIntArray();
        int checksum = 0;

        checksum
                = intData[0]
                + intData[2]
                + intData[4]
                + intData[6]
                + intData[8]
                + intData[10];

        checksum *= 3;
        checksum
                = checksum
                + intData[1]
                + intData[3]
                + intData[5]
                + intData[7]
                + intData[9];

        checksum %= 10;

        if (checksum != 0) {
            checksum = 10 - checksum;
        }

        return checksum;
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
