// TODO: header

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
    
    public static enum LengthUnit {
        INCH,
        CENTIMETER
       
    }
    
    public static enum WeightUnit {
        POUND,
        KILOGRAM
    }
    
    
    protected String nativeLanguage;
    
    
    protected String prefix;
    protected String suffix;
   
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected LocalDate dateOfBirth;
    protected Gender gender;
    protected Sex sex;
    protected double height;
    protected double weight;
    protected int photo;
    
    
    protected List<Address> addresses;
}
