package org.talamona.chapter1.refactor3;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 4/12/13
 * Time: 12:31 PM
 */
public abstract class Price {
    public abstract Movie.codes getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
