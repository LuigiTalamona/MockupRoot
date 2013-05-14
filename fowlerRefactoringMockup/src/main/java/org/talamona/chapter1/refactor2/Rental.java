package org.talamona.chapter1.refactor2;



/**
 *
 * @author luigi
 */
public interface Rental {
    public Integer getDaysRented();
    public Movie getMovie();
    public Double getCharge();
    public int getFrequentRenterPoints();
}
