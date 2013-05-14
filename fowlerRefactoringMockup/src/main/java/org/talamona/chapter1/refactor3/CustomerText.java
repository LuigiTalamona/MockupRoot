package org.talamona.chapter1.refactor3;

import org.talamona.chapter1.original.AbstractCustomer;

import java.util.Iterator;

/**
 *
 * @author luigi
 */
public class CustomerText extends AbstractCustomer {

    public String statement() {
        String retValue = "Rental Record for " + this.getName() + "\n";

        Iterator rentals = this.getRentals().iterator();
        Rental each = null;
        while (rentals.hasNext()) {
            each = (Rental) rentals.next();
            retValue += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
            
        }
        retValue += "Total amount is " + String.valueOf(this.getTotalCharge()) + "\n";
        retValue += "Your points are " + String.valueOf(this.getTotalFrequentRenterPoints()) + "\n";
        return retValue;
    }

    private int getTotalFrequentRenterPoints() {
        int retValue = 0;
        Iterator i = this.getRentals().iterator();
        Rental each = null;
        while(i.hasNext()){
            each = (Rental) i.next();
            retValue += each.getFrequentRenterPoints();
        }
        return retValue;
    }

    private double getTotalCharge() {
        double totalAmount = 0d;
        Iterator i = this.getRentals().iterator();
        Rental each = null;
        while(i.hasNext()){
            each = (Rental) i.next();
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }
}
