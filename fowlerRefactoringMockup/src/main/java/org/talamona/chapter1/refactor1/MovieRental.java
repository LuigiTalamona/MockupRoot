package org.talamona.chapter1.refactor1;

import org.talamona.chapter1.*;
import org.talamona.chapter1.original.Movie;

/**
 *
 * @author luigi
 */
public class MovieRental implements Rental{
    private Integer dayRented;
    private Movie movie;
    
    public Integer getDaysRented(){
        return this.dayRented;
    }
    public Movie getMovie(){
        return this.movie;
    }

    public Double getCharge() {
        Movie.codes actual = this.getMovie().getPriceCode();
        double result = 0;
        switch (actual) {
            case STANDARD:
                {
                    result += 2;
                    if (this.getDaysRented() > 2) {
                        result += (this.getDaysRented() - 2) * 1.5;
                    }
                    break;
                }
            case CHILDREN:
                {
                    result += 1.5;
                    if (this.getDaysRented() > 3) {
                        result += (this.getDaysRented() - 3) * 1.5;
                    }
                    break;
                }
            case NEWS:
                {
                    result += this.getDaysRented() * 3.0;
                    break;
                }
        }
        return Double.valueOf(result);
    }

    public int getFrequentRenterPoints() {
        return ((this.getMovie().getPriceCode() == Movie.codes.NEWS) 
                && this.getDaysRented() > 1) ? 2: 1;
    }
    
    
}
