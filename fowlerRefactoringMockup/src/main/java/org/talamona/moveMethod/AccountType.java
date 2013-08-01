package org.talamona.moveMethod;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 2:14 PM
 */
public class AccountType{

    private boolean premium;

    public AccountType(){
        this.premium = false;
    }
    public AccountType(boolean premium){
        this.premium = premium;
    }
    public boolean isPremium() {
        return this.premium;
    }
}
