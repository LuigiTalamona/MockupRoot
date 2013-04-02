/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.talamona.chapter4.exercise4_10_3;

import java.util.Calendar;
import java.util.Locale;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class BookingSystemNGTest {
    
    private BookingSystem instance;
    private Calendar c;

    public BookingSystemNGTest() {
    }

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                    {"", ""},
                    {"", ""}
        };
    }

    @BeforeMethod
    public void setup(){
        this.instance = new BookingSystem();
        c = Calendar.getInstance(Locale.ITALIAN);
        // Run before every test method
    }
    
    //@Test(dataProvider="getTestValues", expectedExceptions = NullPointerException.class) 
    //@Test
    public void testGetBookedHours(/*Object val1, Object val2*/){
        // Dummy test method: configure DataProvider and specify eventually other
        // exceptions
        Integer[] bookedHours = this.instance.getBookedHours();
        assertTrue(bookedHours.length > 0);

    }
    @Test
    public void testMakeBooking(/*Object val1, Object val2*/){
        System.out.println("testMakeBooking");
        c.set(Calendar.HOUR, 16);
        instance.makeBooking(c);
        c = Calendar.getInstance();
        c.set(Calendar.HOUR, 17);
        instance.makeBooking(c);
        
        Integer[] bookedHours = this.instance.getBookedHours();
        assertEquals(bookedHours.length, 2);

    }
    @Test
    public void testIsFreeHour(/*Object val1, Object val2*/){
        System.out.println("testCheckFreeHour");
        c.set(Calendar.HOUR, 16);
        assertTrue(instance.makeBooking(c));
        assertFalse(instance.makeBooking(c));

    }
    


}