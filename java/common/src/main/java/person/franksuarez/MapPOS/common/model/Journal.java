// TODO: header

package person.franksuarez.MapPOS.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franksuarez
 */
public class Journal {

    private List<Transaction> transactions;
    
    // TODO: create()
    // TODO: read()
    // TODO: update()
    // TODO: delete()

    public Journal() {
        this.transactions = new ArrayList<>();
    }

    public Transaction get(int index) {
        // read
        return this.transactions.get(index);
    }

    public void add(Transaction currentTransaction) {
        this.transactions.add(currentTransaction);
    }
}
