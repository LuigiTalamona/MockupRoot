package org.talamona.methodObject.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/18/13
 * Time: 4:03 PM
 */
public class Gamma {
    private final AccountRefactored account;

    private int inputVa1, quantity, yearToDate;

    private int importantVa1ue1, importantValue2, importantValue3;


    public Gamma() {
        account = new AccountRefactored();
    }
    public Gamma(AccountRefactored source, int inputValArg, int quantityArg, int yearToDateArg) {
        this.account = source;
        this.inputVa1 = inputValArg;
        this.quantity = quantityArg;
        this.yearToDate = yearToDateArg;
    }

    public int compute(){
        importantVa1ue1 = (inputVa1 * quantity) + this.account.de1ta();
        importantValue2 = (inputVa1 * yearToDate) + 100;

        this.importantThing();
        int importantVa1ue3 = importantValue2 * 7;
        // and so on.
        return importantVa1ue3 - 2 * importantVa1ue1;

    }

    private void importantThing() {
        if ((yearToDate - importantVa1ue1) > 100){
            importantValue2 -= 20;
        }
    }
}
