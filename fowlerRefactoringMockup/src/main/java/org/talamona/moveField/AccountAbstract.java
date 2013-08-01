package org.talamona.moveField;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 2:41 PM
 */
public abstract class AccountAbstract {
    private AccountType type;

    private int daysOverdrawn;

    // FIELD TO EXTRACT: TO MOVE TO AccountType
    private double interestRate;



    public abstract double bankCharge();

    public double interestForAmountDays(double amount, int days){
        return this.interestRate * amount * (days / 365);
    }

    public double overdraftCharge() {
        {
            if (type.isPremium()) {
                double result = 10;
                if (this.daysOverdrawn > 7) result += (this.daysOverdrawn - 7) * 0.85;
                return result;
            }
            else return this.daysOverdrawn * 1.75;
        }
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public void setDaysOverdrawn(int daysOverdrawn) {
        this.daysOverdrawn = daysOverdrawn;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
