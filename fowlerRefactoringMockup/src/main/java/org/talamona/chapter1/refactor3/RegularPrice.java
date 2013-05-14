package org.talamona.chapter1.refactor3;

/**
 * Created with IntelliJ IDEA. User: luigi Date: 4/12/13 Time: 12:37 PM To
 * change this template use File | Settings | File Templates.
 */
public class RegularPrice extends Price {

    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return Double.valueOf(result);
    }

    public Movie.codes getPriceCode() {
        return Movie.codes.STANDARD;
    }
}
