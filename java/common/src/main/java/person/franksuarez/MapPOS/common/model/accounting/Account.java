/**
 * 
 * 
 * 
 * 
 */
package person.franksuarez.MapPOS.common.model.accounting;

import java.util.HashMap;

/**
 *
 * @author franksuarez
 */
public class Account {
    public static enum Type {
        ASSET,
        EXPENSE,
        LIABILITY,
        REVENUE,
        EQUITY
    };

    // TODO unsure what to call this
    public static enum Flow {
        DEBIT,
        CREDIT
    }

    private Type type;
    private Flow flow;

    private double amount;

    public static final HashMap<Type, Flow> typeFlowMap;

    static {
        typeFlowMap = new HashMap<>();

        typeFlowMap.put(Type.ASSET, Flow.DEBIT);
        typeFlowMap.put(Type.EQUITY, Flow.CREDIT);
        typeFlowMap.put(Type.EXPENSE, Flow.DEBIT);
        typeFlowMap.put(Type.LIABILITY, Flow.CREDIT);
        typeFlowMap.put(Type.REVENUE, Flow.CREDIT);
    }

    /**
     * Debits the account.
     *
     * Depending on the account type, the amount will increase or decrease.
     *
     * @param amount
     */
    public void debit(double adjustment) {
        if (typeFlowMap.get(this.type) == Flow.DEBIT) {
            this.amount += adjustment;
        } else {
            this.amount -= adjustment;
        }
    }

    /**
     * Credits the account.
     *
     * Depending on the account type, the amount will increase or decrease.
     *
     * @param amount
     */
    public void credit(double adjustment) {
        if (typeFlowMap.get(this.type) == Flow.CREDIT) {
            this.amount += adjustment;
        } else {
            this.amount -= adjustment;
        }
    }
}
