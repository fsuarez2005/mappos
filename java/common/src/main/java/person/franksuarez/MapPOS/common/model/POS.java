// TODO: header

package person.franksuarez.MapPOS.common.model;

import java.util.ArrayList;
import java.util.List;

/** Point of Sale.
 * 
 * 
 * @author franksuarez
 */
public class POS {
    private Journal journal;
    
    private Employee currentOperator;
    
    
    
    
    public enum State {
        IDLE,
        TRANSACTION,
        UPCCHECK
        
    };

    private State state = State.IDLE;
    
    
    
    private Transaction currentTransaction;
    
    
    /** List of transaction on this local unit.
     * 
     * Could have multiple active, but must select which Transaction.
     */
    private List<Transaction> transactions = new ArrayList<>();
    
    
    public POS() {
        this.journal = new Journal();
    }
    
    
    public void startTransaction() {
        this.state = State.TRANSACTION;
        this.currentTransaction = new Transaction();   
    }
    
    public void endTransaction() {
        this.journal.add(this.currentTransaction);
        
        this.state = State.IDLE;
        this.currentTransaction = null;
        
    }

    
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
//    public Transaction getTransaction(int index) {
//        return this.journal.get(index);
//    }
    
    
    
    
    
    
}
