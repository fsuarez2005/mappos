/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package person.franksuarez.MapPOS.model;

import java.util.function.Predicate;

/** Interface for identifiers like UPC.
 *
 * @author franksuarez
 */
public interface ProductIdentifier<T> {
    public boolean isValid();

    public void set(T value);
    public T get();
    
    public void setValidationPredicate(Predicate<T> validator);
    public Predicate<T> getValidationPredicate();
}
