/**
 * 
 * 
 * 
 * 
 */
package person.franksuarez.MapPOS.common.model;

import java.util.List;

/** Generic Business.
 *
 * @author franksuarez
 */
public class Business {
    public static enum Form {
        SOLEPROPRIETORSHIP,
        PARTNERSHIP,
        CORPORATION,
        COOPERATIVE,
        LIMITEDLIABILITYCOMPANY,
        FRANCHISE,
        COMPANYLIMITEDBYGUARANTEE,
        COMPANYLIMITEDBYSHARES,
        UNLIMITEDCOMPANY,
        CORPORATIONSOLE,
        CHARTERCORPORATION,
        STATUTORYCOMPANY
    }
    
    private Form businessForm;
    
    private List<Employee> employees;
    private String name;
    private int logo;
    private int size;
    
    
    private FloorMap rootFloorMap;
    
    
    
    //private List<Fixture> fixtures;
    
    
    
    
    
}
