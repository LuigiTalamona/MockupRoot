package org.talamona.moveField;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 3:44 PM
 */
public class StandardAccount extends AccountAbstract{

    public static AccountAbstract make(){
        AccountAbstract retValue = new StandardAccount();
        retValue.setType(new AccountType(false));
        retValue.setDaysOverdrawn(5);
        return retValue;
    }

    @Override
    public double bankCharge() {
        double result = 2.0d;
        if (this.getDaysOverdrawn() > 0) {
            result += this.overdraftCharge();
        }
        return result;
    }
}
