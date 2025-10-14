/** UPCA.
 * 
 * 
 * 
 * 
 */

// TODO: Need to test and check for bugs.


package person.franksuarez.MapPOS.common.model;
import person.franksuarez.MapPOS.common.exception.InvalidFormat;

/** UPCA.
 *
 * @author franksuarez
 */
public class UPCA extends GTIN implements java.io.Serializable {


    public UPCA() {
        this.setFormatLength( 12 );
        this.setCheckDigitIndex( 11 );
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

        return (intData[getCheckDigitIndex()] == calculateCheckDigit());
    }
    

    
}
