/** GTIN.
 * 
 * 
 * 
 * 
 * 
 */
package person.franksuarez.MapPOS.common.model;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;


/** Global Trade Identification Number.
 * 
 * 
 * https://www.gs1.org/standards/id-keys/gtin
 * https://en.wikipedia.org/wiki/Global_Trade_Item_Number
 *
 * @author franksuarez
 */
public class GTIN extends ProductIdentifier implements java.io.Serializable {


    @Override
    public boolean isCharValid(char c) {
        return Character.isDigit(c);
    }
    
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
        for (int i = this.getData().length - 2; i >= 0; i--) {
            
            // assumes the data are digits
            int digit = Character.getNumericValue(this.getData()[i]);
            
            sum += multiplyByThree ? digit * 3 : digit;
            multiplyByThree = !multiplyByThree;
        }

        // Calculate the check digit
        int checkDigit = (10 - (sum % 10)) % 10;
        return checkDigit;
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
        if (intData.length < getFormatLength()) {
            throw new InvalidFormat();
        }
        return intData[getCheckDigitIndex()] == calculateCheckDigit();
    }

        @Override
    public boolean isValid() {
        // super.isValid validates length and char type
        
        boolean validCheckDigit = false;
        try {
            validCheckDigit = hasValidCheckDigit();
        } catch (InvalidFormat ex) {
            System.getLogger(GTIN.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        
        
        return (super.isValid() && validCheckDigit); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
  
    
}
