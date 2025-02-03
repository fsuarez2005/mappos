// TODO: header

// TODO: Need to test and check for bugs.


package person.franksuarez.MapPOS.common.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;


// TODO: implement serialization
/**
 *
 * @author franksuarez
 */
public class UPCA extends UPC implements java.io.Serializable {

    private int checkDigitIndex = 11;

    public UPCA() {
        formatLength = 12;
    }

    /**
     * TODO: move to GTIN and generalize
     * 
     * @return Check digit for the UPC.
     * @throws person.franksuarez.MapPOS.exception.InvalidFormat
     */
    public int calculateCheckDigit() throws InvalidFormat {
        
        
        
        
        // validate format of charData
        if (!hasOnlyDigits()) {
            throw new InvalidFormat();
        }
        if (!isCorrectFormatLength()) {
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

    @Override
    public boolean isValid() {
        boolean valid = super.isValid();
        boolean hasOnlyDigits = super.hasOnlyDigits();
        boolean hasValidCheckDigit;
        try {
            hasValidCheckDigit = this.hasValidCheckDigit();
        } catch (InvalidFormat ex) {
            Logger.getLogger(UPCA.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return hasOnlyDigits && valid && hasValidCheckDigit;
    }

    /**
     *
     *
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
