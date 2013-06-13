package org.talamona.extractmethod;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/6/13
 * Time: 10:49 AM
 */
public class RefactoredExampleClass implements BaseExample {
    private Collection orders;

    public RefactoredExampleClass(Collection orders){
        this.orders = orders;
    }

    public double printOwing() {
        Iterator e = this.orders.iterator();
        double outstanding = 0.0;
        String name = "name";

        //printBanner
        this.printBanner();

        // calculate outstanding
        outstanding = this.getOutstanding();

        //print details
        this.printDetails(outstanding, name);

        return outstanding;
    }

    public double printOwing(double base) {
        String name = "overloaded";

        //printBanner
        this.printBanner();

        // calculate outstanding
        double outstanding = this.getOutstanding() + base;

        //print details
        this.printDetails(outstanding, name);
        return outstanding;
    }

    private double getOutstanding() {
        Iterator e = this.orders.iterator();
        double retValue = 0.0;
        while (e.hasNext()){
            Order each = (Order)e.next();
            retValue += each.getAmount();
        }
        return retValue;
    }

    private void printDetails(double outstanding, String name) {
        System.out.println ("name:	" + name);
        System.out.println ("amount	" + outstanding);
    }

    private void printBanner() {
        System.out.println ("********************************************");
        System.out.println ("************ CUSTOMER OWES *****************");
        System.out.println ("********************************************");
    }
}
