package org.talamona.chapter1.refactor3;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
        Mockito.when(movie1.getCharge(5)).thenReturn(15d);
        Mockito.when(instance.getDaysRented()).thenReturn(5);
        Mockito.when(instance.getMovie()).thenReturn(movie1);

        Double expected = 15d;
        Double actual = instance.getCharge();
        assertEquals(actual, expected);
    }
}