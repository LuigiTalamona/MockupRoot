package org.talamona.moveField.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 2:41 PM
 */

public abstract class AccountAbstractRefactored {
    AccountTypeRefactored type;
    private int daysOverdrawn;

    public abstract double bankCharge();

    public double interestForAmountDays(double amount, int days){
        return this.getInterestRate() * amount * (days / 365);
    }

    public AccountTypeRefactored getType() {
        return type;
    }

    public void setType(AccountTypeRefactored type) {
        this.type = type;
    }

    public int getDaysOverdrawn() {
        return this.daysOverdrawn;
    }

    public void setDaysOverdrawn(int daysOverdrawn) {
        this.daysOverdrawn = daysOverdrawn;
    }

    public double getInterestRate() {
        return this.type.getInterestRate();
    }

    public void setInterestRate(double interestRate) {
        this.type.setInterestRate(interestRate);
    }
}
