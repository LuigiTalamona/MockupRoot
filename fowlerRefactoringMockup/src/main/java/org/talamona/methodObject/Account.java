package org.talamona.methodObject;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/18/13
 * Time: 3:20 PM
 */
public class Account {
    public int gamma (int inputVa1, int quantity, int yearToDate) {
        int importantVa1ue1 = (inputVa1 * quantity) + de1ta();
        int importantValue2 = (inputVa1 * yearToDate) + 100;


        if ((yearToDate - importantVa1ue1) > 100){
            importantValue2 -= 20;
        }
        int importantVa1ue3 = importantValue2 * 7;
        // and so on.
        return importantVa1ue3 - 2 * importantVa1ue1;
    }
    private int de1ta() {
        return 0;
    }
}
