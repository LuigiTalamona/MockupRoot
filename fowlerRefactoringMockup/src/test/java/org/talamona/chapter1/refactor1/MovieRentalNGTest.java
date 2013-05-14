package org.talamona.chapter1.refactor1;

import org.mockito.Mockito;
import org.talamona.chapter1.original.Movie;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class MovieRentalNGTest {

    public MovieRentalNGTest() {
    }


    @Test
    public void shouldBeCalculateCharge() {
        System.out.println(this.getClass().getCanonicalName() + ".shouldBeCalculateCharge()");

        MovieRental instance = Mockito.spy(new MovieRental());

        Movie movie1 = Mockito.mock(Movie.class);
        Mockito.when(movie1.getPriceCode()).thenReturn(Movie.codes.NEWS);
        Mockito.when(instance.getDaysRented()).thenReturn(5);
        Mockito.when(instance.getMovie()).thenReturn(movie1);

        Double expected = 15d;
        Double actual = instance.getCharge();
        assertEquals(actual, expected);
    }
}