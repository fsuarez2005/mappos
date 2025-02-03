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
     * TODO
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

        if (this.intData == null) {
            // try to generate intData
            // throws InvalidFormat if a problem
            generateDigitOnlyData();

            // if all fails, throw nullpointer
            throw new NullPointerException("Need to call generateDigitOnlyData()");
        }

        int checksum = 0;

        checksum
                = this.intData[0]
                + this.intData[2]
                + this.intData[4]
                + this.intData[6]
                + this.intData[8]
                + this.intData[10];

        checksum *= 3;
        checksum
                = checksum
                + this.intData[1]
                + this.intData[3]
                + this.intData[5]
                + this.intData[7]
                + this.intData[9];

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
     */
    public boolean hasValidCheckDigit() throws InvalidFormat {
        if (this.intData == null) {
            throw new NullPointerException();
        }
        if (this.intData.length < formatLength) {
            throw new InvalidFormat();
        }

        return (this.intData[checkDigitIndex] == calculateCheckDigit());
    }

}
