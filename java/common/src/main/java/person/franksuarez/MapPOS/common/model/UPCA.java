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
    
    

    
}
