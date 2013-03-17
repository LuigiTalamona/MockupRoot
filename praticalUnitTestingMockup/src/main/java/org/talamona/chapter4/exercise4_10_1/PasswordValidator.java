package org.talamona.chapter4.exercise4_10_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luigi
 */
class PasswordValidator {

    private int passwordLenght;

    public PasswordValidator(int passwordLenght) {
        this.passwordLenght = passwordLenght;
    }

    public boolean validatePassword(String pwd) {
        boolean retValue = this.checkPasswordLenght(pwd);
        retValue = retValue && this.isContainingDigits(pwd);
        retValue = retValue && this.isContainingUnderscore(pwd);
        return retValue;
    }
    public int getPwdLenght() {
        return this.passwordLenght;
    }
    protected boolean checkPasswordLenght(String pwd) {
        return (pwd.length() >= this.passwordLenght);
    }
    protected boolean isContainingDigits(String pwd) {
        // Search for a digit in pwd string
        Pattern pattern = Pattern.compile("\\d{1}");
        Matcher matcher = pattern.matcher(pwd);

        /*
        boolean retValue = pwd.indexOf('0') >= 0;
        retValue = retValue || pwd.indexOf('1') >= 0;
        retValue = retValue || pwd.indexOf('2') >= 0;
        retValue = retValue || pwd.indexOf('3') >= 0;
        retValue = retValue || pwd.indexOf('4') >= 0;
        retValue = retValue || pwd.indexOf('5') >= 0;
        retValue = retValue || pwd.indexOf('6') >= 0;
        retValue = retValue || pwd.indexOf('7') >= 0;
        retValue = retValue || pwd.indexOf('8') >= 0;
        retValue = retValue || pwd.indexOf('9') >= 0;
        */ 

        return matcher.find();
    }
    protected boolean isContainingUnderscore(String pwd) {
        return (pwd.indexOf("_") >= 0);
    }
}
