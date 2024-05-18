/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import person.franksuarez.MapPOS.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class UPCA extends UPC {

    /**
     * Checks formatting of a UPC. Checks length and the contents of the data.
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

    
    /** Checks charData for valid data.
     * 
     * @return 
     */
    public boolean isFormattedCorrectly() {
        return (this.charData.length == formatLength);
    }
    
    
    /**
     *
     * @return Check digit for the UPC.
     */
    public int calculateCheckDigit() {
        int checksum = 0;

        checksum
                = this.data[0]
                + this.data[2]
                + this.data[4]
                + this.data[6]
                + this.data[8]
                + this.data[10];

        checksum *= 3;
        checksum
                = checksum
                + this.data[1]
                + this.data[3]
                + this.data[5]
                + this.data[7]
                + this.data[9];

        checksum %= 10;

        if (checksum != 0) {
            checksum = 10 - checksum;
        }

        return checksum;
    }
    
    /**
     *
     * @param upcStr The UPC as a String 12 digits.
     * @throws person.franksuarez.MapPOS.exception.InvalidFormat
     */
    public void setDataAndValidate(String upcStr) throws InvalidFormat {
        if (!isFormattedCorrectlyStatic(upcStr)) {
            throw new InvalidFormat();
        }

        this.data = new int[upcStr.length()];

        for (int n = 0; n < upcStr.length(); n++) {
            char c = upcStr.charAt(n);
            this.data[n] = Character.digit(c, 10);
        }
    }

    /** 
     * 
     * 
     * @return The UPC as a int[], similar to how it is stored internally.
     */
    public int[] getIntArray() {
        return this.data;
    }

    /**
     *
     * @return True if UPC has a good check digit.
     */
    public boolean hasValidCheckDigit() {
        int checkDigit = calculateCheckDigit();
        return (this.data[11] == checkDigit);
    }

}
