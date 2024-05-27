
package person.franksuarez.MapPOS.beans;

import java.beans.*;


/**
 *
 * @author franksuarez
 */
public class POS implements java.io.Serializable {
    private person.franksuarez.MapPOS.model.POS posModel;
    
    
    private int currentTime = 0;
    private String name = "";
    
    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
}
