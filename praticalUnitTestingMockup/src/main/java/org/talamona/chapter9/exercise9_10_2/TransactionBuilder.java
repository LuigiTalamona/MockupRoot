package org.talamona.chapter9.exercise9_10_2;

/**
 *
 * @author luigi
 */
public class TransactionBuilder {
    private Transaction transaction;

    public TransactionBuilder() {
        this.transaction = new Transaction();
    }
    public TransactionBuilder withId(long id) {
        this.transaction.setId(id);
        return this;
    }
    public TransactionBuilder withState(String state) {
        this.transaction.setState(state);
        return this;
    }
    public TransactionBuilder withRetryAllowed(boolean retry) {
        this.transaction.setRetry(retry);
        return this;
    }
    public TransactionBuilder withMessage(String message) {
        this.transaction.setMessage(message);
        return this;
    }
    public TransactionBuilder withBillingId(String id) {
        this.transaction.setBillingId(id);
        return this;
    }
    public Transaction build(){
        return this.transaction;
    }
}
