/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.talamona.chapter6.exercise6_12_4;

import java.util.Calendar;
import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class TimeTestNG {
    private HelpDesk instance;
    private Calendar c;
    
    public TimeTestNG() {
    }

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                    {Calendar.MONDAY, true},
                    {Calendar.TUESDAY, true},
                    {Calendar.THURSDAY, true},
                    {Calendar.WEDNESDAY, true},
        };
    }
    @DataProvider
    private Object[][] getWeekendValues() {
        return new Object[][]{
                    {Calendar.SATURDAY, false},
                    {Calendar.SUNDAY, false}
        };
    }

    @BeforeMethod
    public void setup(){
        this.instance = new HelpDesk();
        c = Mockito.mock(Calendar.class);
        this.instance.setCalendar(c);
    }
    @Test(dataProvider="getWeekendValues")
    public void shouldBeFalseOnWeekend(int day, boolean response){
        Mockito.when(c.get(Calendar.DAY_OF_WEEK)).thenReturn(day);
        assertEquals(this.instance.willHandleIssue(new Issue()), response);
    }
    @Test
    public void shouldBeFalseOnFridayAfterEOB(){
        // EOB = End of Business = Five pm.
        Mockito.when(c.get(Calendar.DAY_OF_WEEK)).thenReturn(Calendar.FRIDAY);
        Mockito.when(c.get(Calendar.HOUR_OF_DAY)).thenReturn(18);
        assertFalse(this.instance.willHandleIssue(new Issue()));
    }
    @Test
    public void shouldBeTrueOnFridayBeforeEOB(){
        // EOB = End of Business = Five pm.
        Mockito.when(c.get(Calendar.DAY_OF_WEEK)).thenReturn(Calendar.FRIDAY);
        Mockito.when(c.get(Calendar.HOUR_OF_DAY)).thenReturn(16);
        assertTrue(this.instance.willHandleIssue(new Issue()));
    }
    @Test(dataProvider="getTestValues")
    public void shouldBeTrueOnJobDays(int day, boolean response){
        Mockito.when(c.get(Calendar.DAY_OF_WEEK)).thenReturn(day);
        Mockito.when(c.get(Calendar.HOUR_OF_DAY)).thenReturn(Mockito.anyInt());
        assertEquals(this.instance.willHandleIssue(new Issue()), response);
    }
    

}