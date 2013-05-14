package org.talamona.chapter1.refactor3;

/**
 * @author luigi
 */
public class Movie {

    private String title;
    private Price price;



    public static enum codes {
        STANDARD, CHILDREN, NEWS;
    }

    public codes getPriceCode() {
        return this.price.getPriceCode();
    }

    public void setPriceCode(codes code) {
        switch (code) {
            case STANDARD:{
                this.price = new RegularPrice();
                break;
            }
            case CHILDREN:{
                this.price = new ChildrenPrice();
                break;
            }
            case NEWS:{
                this.price = new NewReleasePrice();
                break;
            }
        }
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);

    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
