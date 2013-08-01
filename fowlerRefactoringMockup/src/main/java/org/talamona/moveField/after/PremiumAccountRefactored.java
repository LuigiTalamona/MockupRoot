package org.talamona.moveField.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 2:13 PM
 */
public class PremiumAccountRefactored extends AccountAbstractRefactored {


    public static AccountAbstractRefactored make() {
        PremiumAccountRefactored retValue = new PremiumAccountRefactored();
        retValue.setDaysOverdrawn(10);
        retValue.setType(new AccountTypeRefactored(true));
        return retValue;
    }

    @Override
    public double bankCharge() {
        double result = 4.5;
        if (this.getDaysOverdrawn() > 0) result += type.overdraftCharge(this.getDaysOverdrawn());
        return result;
    }
}
