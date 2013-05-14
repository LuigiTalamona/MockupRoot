package org.talamona.chapter1.refactor3;

/**
 * Created with IntelliJ IDEA. User: luigi Date: 4/12/13 Time: 12:37 PM To
 * change this template use File | Settings | File Templates.
 */
public class NewReleasePrice extends Price {

    public double getCharge(int daysRented) {
        return daysRented * 3.0;
    }

    public Movie.codes getPriceCode() {
        return Movie.codes.NEWS;
    }
    
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
    
}
