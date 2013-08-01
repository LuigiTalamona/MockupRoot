package org.talamona.moveMethod;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 2:13 PM
 */
public class PremiumAccount extends AccountAbstract {


    public static AccountAbstract make() {
        PremiumAccount retValue = new PremiumAccount();
        retValue.setDaysOverdrawn(10);
        retValue.setType(new AccountType(true));
        return retValue;
    }

    @Override
    public double bankCharge() {
        double result = 4.5;
        if (this.getDaysOverdrawn() > 0) result += this.overdraftCharge();
        return result;
    }
}
