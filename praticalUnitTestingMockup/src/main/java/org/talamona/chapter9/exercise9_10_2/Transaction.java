package org.talamona.chapter9.exercise9_10_2;

/**
 *
 * @author luigi
 */
public class Transaction {
    private long id;
    private String state, message, billingId;
    private boolean retry;

    Transaction(long id, String state, String message, String billingId, boolean retry) {
        
    }

    Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }
    
}
