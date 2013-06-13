package org.talamona.extractmethod;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/6/13
 * Time: 10:49 AM
 */
public class BaseExampleClass implements BaseExample {
    private Collection orders;

    public BaseExampleClass(Collection orders){
        this.orders = orders;
    }

    @Override
    public double printOwing() {
        Iterator e = this.orders.iterator();
        double outstanding = 0.0;
        String name = "name";

        //printBanner
        System.out.println ("********************************************");
        System.out.println ("************ CUSTOMER OWES *****************");
        System.out.println ("********************************************");

        // calculate outstanding
        while (e.hasNext()){
            Order each = (Order)e.next();
            outstanding += each.getAmount();
        }

        //print details
        System.out.println ("name:	" + name);
        System.out.println ("amount	" + outstanding);

        return outstanding;
    }

    /*
    void printOwing() {
        printBanner();
        printDetails(getOutstanding());
    }

    void printDetails (double outstanding) {
        System.out.println ("name:	" + _name);
        System.out.println ("amount	" + outstanding);
    }
    */
}
