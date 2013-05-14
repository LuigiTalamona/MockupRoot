package org.talamona.chapter1.refactor2;



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
        return this.getMovie().getCharge(this.getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return this.getMovie().getFrequentRenterPoints(this.getDaysRented());
    }
    
    
}
