// TODO: header

// TODO: Need to test and check for bugs.


package person.franksuarez.MapPOS.common.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/**
 *
 * @author franksuarez
 */
public class UPCA extends GTIN implements java.io.Serializable {


    public UPCA() {
        this.formatLength = 12;
        this.checkDigitIndex = 11;
        
        // only digits are valid
        /*
        this.isCharValidOld = (Character c) -> {
            return (Character.isDigit(c));
        };
        */
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
    
    /*   
    public static boolean isValid(String s) {
        Pattern upcaPattern = Pattern.compile("^\\d{12}$");
        Matcher upcaMatcher = upcaPattern.matcher(s);
        return upcaMatcher.find();
    }
    */



}
