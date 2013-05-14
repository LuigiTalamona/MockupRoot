package org.talamona.chapter1;

import org.talamona.chapter1.original.Movie;
import org.talamona.chapter1.original.CustomerText;
import org.talamona.chapter1.original.CustomerHtml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class StatementNGTest {
    
    
    private enum DataTypes {TEXT, HTML};
    private final String textFile = "report.txt";
    private final String htmlFile = "report.html";


    public StatementNGTest() {
    }

    @Test
    public void shouldBeCreateStatement() {
        System.out.println(this.getClass().getCanonicalName() + ".shouldBeCreateTextStatement()");
        Customer sut = this.prepareSut(DataTypes.TEXT);
        String expected = this.readSampleData(DataTypes.TEXT);
        String actual = sut.statement();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeCreateHtmlStatement() {
        System.out.println(this.getClass().getCanonicalName() + ".shouldBeCreateHtmlStatement()");
        Customer sut = this.prepareSut(DataTypes.HTML);
        String expected = this.readSampleData(DataTypes.HTML);
        String actual = sut.statement();
        assertEquals(actual, expected);
    }

    private Customer prepareSut(DataTypes type) {
        Customer retValue = null;
        retValue = (type == DataTypes.TEXT)? Mockito.spy(new CustomerText()):
        Mockito.spy(new CustomerHtml());        

        Rental rental1 = Mockito.mock(Rental.class);
        Rental rental2 = Mockito.mock(Rental.class);
        Rental rental3 = Mockito.mock(Rental.class);

        Movie movie1 = Mockito.mock(Movie.class);
        Movie movie2 = Mockito.mock(Movie.class);
        Movie movie3 = Mockito.mock(Movie.class);

        Mockito.when(movie1.getPriceCode()).thenReturn(Movie.codes.NEWS);
        Mockito.when(movie1.getTitle()).thenReturn("Host");

        Mockito.when(movie2.getPriceCode()).thenReturn(Movie.codes.STANDARD);
        Mockito.when(movie2.getTitle()).thenReturn("Apocalypse Now");

        Mockito.when(movie3.getPriceCode()).thenReturn(Movie.codes.CHILDREN);
        Mockito.when(movie3.getTitle()).thenReturn("Bambi");

        Mockito.when(rental1.getDaysRented()).thenReturn(10);
        Mockito.when(rental2.getDaysRented()).thenReturn(5);
        Mockito.when(rental3.getDaysRented()).thenReturn(5);

        Mockito.when(rental1.getMovie()).thenReturn(movie1);
        Mockito.when(rental2.getMovie()).thenReturn(movie2);
        Mockito.when(rental3.getMovie()).thenReturn(movie3);

        List<Rental> rentals = new ArrayList<Rental>();
        rentals.add(rental1);
        rentals.add(rental2);
        rentals.add(rental3);

        Mockito.when(retValue.getRentals()).thenReturn(rentals);
        Mockito.when(retValue.getName()).thenReturn("Luigi");
        
        return retValue;


    }
    private String readSampleData(DataTypes type) {
        String retValue = null;
        try {
            String dataFile = (type == DataTypes.TEXT)? textFile: htmlFile;
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(dataFile);
            byte[] fileData = new byte[stream.available()];
            stream.read(fileData);
            stream.close();
            retValue = new String(fileData, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return retValue;
    }
}