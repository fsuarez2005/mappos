// TODO: header

package person.franksuarez.MapPOS.common.model;

// TODO: implement serialization

/** Global Trade Identification Number.
 * 
 * 
 * https://www.gs1.org/standards/id-keys/gtin
 * https://en.wikipedia.org/wiki/Global_Trade_Item_Number
 *
 * @author franksuarez
 */
public class GTIN implements java.io.Serializable {
    
    /** GTIN.data should be able to hold any kind of data.
     * 
     */
    //public byte[] data;
    
    public class Prefix {
        private int width;
        private char[] minimum;
        private char[] maximum;
        private String description;
        
        
        
        
    }
    
    public void fromString() {
        // TODO: STUB: GTIN.fromString
        throw new UnsupportedOperationException();
    }
    
    
    public boolean isValid() {
        return true;
    }
    
    
    
}
