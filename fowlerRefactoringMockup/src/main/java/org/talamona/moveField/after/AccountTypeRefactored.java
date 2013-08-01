package org.talamona.moveField.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 2:14 PM
 */
public class AccountTypeRefactored {

    // FIELD FROM AccountAbstractRefactored
    private double interestRate;


    private boolean premium;

    public AccountTypeRefactored(){
        this.premium = false;
    }
    public AccountTypeRefactored(boolean premium){
        this.premium = premium;
    }
    public boolean isPremium() {
        return this.premium;
    }

    public double overdraftCharge(int daysOverdrawn) {
        {
            if (isPremium()) {
                double result = 10;
                if (daysOverdrawn > 7) result += (daysOverdrawn - 7) * 0.85;
                return result;
            }
            else return daysOverdrawn * 1.75;
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
