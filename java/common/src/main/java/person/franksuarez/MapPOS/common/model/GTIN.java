// TODO: header

package person.franksuarez.MapPOS.common.model;

// TODO: implement serialization

import person.franksuarez.MapPOS.common.exception.InvalidFormat;


/** Global Trade Identification Number.
 * 
 * 
 * https://www.gs1.org/standards/id-keys/gtin
 * https://en.wikipedia.org/wiki/Global_Trade_Item_Number
 *
 * @author franksuarez
 */
public class GTIN extends LinearBarcode implements java.io.Serializable {
    // TODO: generic Check Digit method
    
    
    /** Calculates the check digit for a GTIN, regardless of length.
     * 
     * @return Check digit of GTIN
     * @throws InvalidFormat 
     */
    public int calculateCheckDigit() throws InvalidFormat {
        // char[] this.data
        
        // Source: ChatGPT 
        int sum = 0;
        boolean multiplyByThree = true;

        // Process digits from right to left
        for (int i = this.data.length - 2; i >= 0; i--) {
            int digit = Character.getNumericValue(this.data[i]);
            sum += multiplyByThree ? digit * 3 : digit;
            multiplyByThree = !multiplyByThree;
        }

        // Calculate the check digit
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit;
    }
    
    
    
}
