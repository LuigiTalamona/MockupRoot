package org.talamona.moveField.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 3:44 PM
 */
public class StandardAccountRefactored extends AccountAbstractRefactored {

    public static AccountAbstractRefactored make(){
        AccountAbstractRefactored retValue = new StandardAccountRefactored();
        retValue.setType(new AccountTypeRefactored(false));
        retValue.setDaysOverdrawn(5);
        return retValue;
    }

    @Override
    public double bankCharge() {
        double result = 2.0d;
        if (this.getDaysOverdrawn() > 0) {
            result += type.overdraftCharge(this.getDaysOverdrawn());
        }
        return result;
    }
}
