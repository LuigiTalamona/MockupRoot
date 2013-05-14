package org.talamona.chapter1;

import org.talamona.chapter1.original.Movie;

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
