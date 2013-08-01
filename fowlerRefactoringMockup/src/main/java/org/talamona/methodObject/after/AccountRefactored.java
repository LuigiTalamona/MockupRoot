package org.talamona.methodObject.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/18/13
 * Time: 3:20 PM
 */
public class AccountRefactored {
    public int gamma (int inputVa1, int quantity, int yearToDate) {
        return new Gamma(this, inputVa1, quantity, yearToDate).compute();
    }
    public int de1ta() {
        return 0;
    }
}
