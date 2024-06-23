/**
 * 
 * 
 * 
 * 
 * 
 */
package person.franksuarez.MapPOS.common.model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author franksuarez
 */
public class Person {
    public static enum Sex {
        MALE,
        FEMALE,
        INTERSEX
    };
    
    public static enum Gender {
        MASCULINE,
        FEMININE,
        NONBINARY
    }
    
    
    private String nativeLanguage;
    
    
    private String prefix;
    private String suffix;
   
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Sex sex;
    private double height;
    private double weight;
    private int photo;
    
    
    private List<Address> addresses;
    


}
