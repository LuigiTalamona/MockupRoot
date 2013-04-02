package org.talamona.chapter6.example6_8;

import java.util.Calendar;
import java.util.Locale;
import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
//*/
public class HelloRefactoredNGTest {
    private HelloRefactored instance;
    private TimeProvider timeProvider;

    public HelloRefactoredNGTest() {
    }

    @DataProvider
    private Object[][] morningHours() {
        return new Object[][]{
                    {0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11}
        };
    }
    @DataProvider
    private Object[][] afternoonHours() {
        return new Object[][]{
                    {12},{13},{14},{15},{16},{17},{18},{19},{20},{21},{22},{23}
        };
    }

    @BeforeMethod
    public void setup(){
        this.timeProvider = Mockito.mock(TimeProvider.class);
        this.instance = new HelloRefactored(this.timeProvider);
    }
    

    @Test(dataProvider="morningHours")
    public void shouldSayGoodMorningInMorning(int hour) {
        System.out.println("shouldSayGoodMorningInMorning");
        Mockito.when(this.timeProvider.getTime()).thenReturn(this.getCalendar(hour));
        
        String expResult = "Good Morning";
        String result = instance.sayHello();
        assertEquals(result, expResult);
    }
    @Test(dataProvider="afternoonHours")
    public void shouldSayGoodAfternoonInAfternoon(int hour) {
        System.out.println("shouldSayGoodAfternoonInAfternoon");
        Mockito.when(this.timeProvider.getTime()).thenReturn(this.getCalendar(hour));
        
        String expResult = "Good Afternoon";
        String result = instance.sayHello();
        assertEquals(result, expResult);
    }

    private Calendar getCalendar(int hour) {
        Calendar c = Calendar.getInstance(Locale.ITALIAN);
        c.set(Calendar.HOUR_OF_DAY, hour);
        return c;
    }

}