package org.talamona.chapter1.original;

import java.util.Iterator;
import org.talamona.chapter1.Rental;

/**
 *
 * @author luigi
 */
public class CustomerHtml extends AbstractCustomer {

    public String statement() {
        String retValue = "<h1>Rental Record for " + this.getName() + 
                          "</h1><br/><table>";
        
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator rentals = this.getRentals().iterator();
        Rental r = null;
        while (rentals.hasNext()) {
            double thisAmount = 0;
            r = (Rental) rentals.next();
            Movie.codes actual = r.getMovie().getPriceCode();

            switch (actual) {
                case STANDARD: {
                    thisAmount += 2;
                    if (r.getDaysRented() > 2) {
                        thisAmount += (r.getDaysRented() - 2) * 1.5d;
                    }
                    break;
                }
                case CHILDREN: {
                    thisAmount += 1.5d;
                    if (r.getDaysRented() > 3) {
                        thisAmount += (r.getDaysRented() - 3) * 1.5d;
                    }
                    break;
                }
                case NEWS: {
                    thisAmount += r.getDaysRented() * 3d;
                    break;
                }
            }
            frequentRenterPoints++;
            if ((r.getMovie().getPriceCode() == Movie.codes.NEWS)
                    && r.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            retValue += "<tr><td>" + r.getMovie().getTitle() + "</td><td>" + 
                    String.valueOf(thisAmount) + "</td></tr>";
            totalAmount += thisAmount;
        }
        retValue += "<tr><td colspan='2'>Total amount is " + 
                String.valueOf(totalAmount) + "</td></tr>";
        retValue += "<tr><td colspan='2'>Your points are " + 
                String.valueOf(frequentRenterPoints) + "</td></tr>";
        
        retValue += "</table>";
        return retValue;
    }
}
