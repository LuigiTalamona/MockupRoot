package org.talamona.chapter1.refactor2;

/**
 * @author luigi
 */
public class Movie {

    private String title;
    private codes priceCode;


    public static enum codes {
        STANDARD, CHILDREN, NEWS;
    }

    public codes getPriceCode() {
        return this.priceCode;
    }

    public void setPriceCode(codes code) {
        this.priceCode = code;
    }

    public double getCharge(int daysRented) {
        double result = 0;
        switch (this.getPriceCode()) {
            case STANDARD: {
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            }
            case CHILDREN: {
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
            }
            case NEWS: {
                result += daysRented * 3.0;
                break;
            }
        }
        return Double.valueOf(result);

    }

    public int getFrequentRenterPoints(int daysRented) {
        return ((this.getPriceCode() == codes.NEWS) && daysRented > 1) ? 2: 1;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
