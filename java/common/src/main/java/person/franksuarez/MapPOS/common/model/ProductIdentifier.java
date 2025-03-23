// TODO: header

package person.franksuarez.MapPOS.common.model;

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
