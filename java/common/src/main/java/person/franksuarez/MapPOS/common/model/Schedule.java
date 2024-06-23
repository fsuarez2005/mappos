
package person.franksuarez.MapPOS.common.model;

import java.time.LocalDateTime;
import java.util.List;

/** Collection of shifts.
 *
 * @author franksuarez
 */
public class Schedule {
    private List<Shift> shifts;
    
    
    /**
     * 
     * 
     */
    public static class Shift {
        private LocalDateTime inTime;
        private LocalDateTime outTime;
        private String role;
        private Employee employee;
    }
}
