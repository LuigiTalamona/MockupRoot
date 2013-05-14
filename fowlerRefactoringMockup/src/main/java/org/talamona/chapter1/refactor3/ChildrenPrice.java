package org.talamona.chapter1.refactor3;

/**
 * Created with IntelliJ IDEA. User: luigi Date: 4/12/13 Time: 12:33 PM To
 * change this template use File | Settings | File Templates.
 */
public class ChildrenPrice extends Price {

    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return Double.valueOf(result);
    }

    public Movie.codes getPriceCode() {
        return Movie.codes.CHILDREN;
    }
}
