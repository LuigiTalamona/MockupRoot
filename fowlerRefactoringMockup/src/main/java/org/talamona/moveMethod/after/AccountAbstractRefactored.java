package org.talamona.moveMethod.after;

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

    public AccountTypeRefactored getType() {
        return type;
    }

    public void setType(AccountTypeRefactored type) {
        this.type = type;
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public void setDaysOverdrawn(int daysOverdrawn) {
        this.daysOverdrawn = daysOverdrawn;
    }
}
