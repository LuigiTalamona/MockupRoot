package org.talamona.chapter1.refactor3;

import org.mockito.Mockito;
import org.testng.annotations.Test;
import org.talamona.chapter1.Customer;
import org.talamona.chapter1.original.CustomerHtml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

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

    //@Test
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

        Rental rental1 = Mockito.spy(new MovieRental());
        Rental rental2 = Mockito.spy(new MovieRental());
        Rental rental3 = Mockito.spy(new MovieRental());

        Movie movie1 = Mockito.spy(new Movie());
        Movie movie2 = Mockito.spy(new Movie());
        Movie movie3 = Mockito.spy(new Movie());
        
        movie1.setPriceCode(Movie.codes.NEWS);
        Mockito.when(movie1.getTitle()).thenReturn("Host");

        movie2.setPriceCode(Movie.codes.STANDARD);
        Mockito.when(movie2.getTitle()).thenReturn("Apocalypse Now");

        movie3.setPriceCode(Movie.codes.CHILDREN);
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