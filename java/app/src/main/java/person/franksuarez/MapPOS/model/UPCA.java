/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import person.franksuarez.MapPOS.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class UPCA extends UPC {
    private int checkDigitIndex = 11;
    
    
    /**
     * Checks formatting of a UPC. Checks length and the contents of the data.
     * TODO: split this method up TODO: remove
     *
     * @param dataStr
     * @return True if formatting is correct.
     */
    public static boolean isFormattedCorrectlyStatic(String dataStr) {
        int dataStrLen = dataStr.length();

        // has 12 digits
        boolean correctLength = 12 == dataStrLen;

        // only has digits
        boolean onlyHasDigits = true;
        for (int n = 0; n < dataStrLen; n++) {
            if (!Character.isDigit(dataStr.charAt(n))) {
                onlyHasDigits = false;
                break;
            }
        }
        return (correctLength && onlyHasDigits);
    }

    public UPCA() {
        formatLength = 12;
    }

    /**
     *
     * @return Check digit for the UPC.
     * @throws person.franksuarez.MapPOS.exception.InvalidFormat
     */
    public int calculateCheckDigit() throws InvalidFormat {
        
        // validate format of charData
        if (! hasOnlyDigits()) {
            throw new InvalidFormat();
        }
        if (! isCorrectFormatLength()) {
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
        boolean hasOnlyDigits = super.hasOnlyDigits();
        boolean valid = super.isValid();
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
        return (this.intData[checkDigitIndex] == calculateCheckDigit());
    }

}
