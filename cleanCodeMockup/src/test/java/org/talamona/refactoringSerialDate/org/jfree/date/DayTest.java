package org.talamona.refactoringSerialDate.org.jfree.date;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/2/13
 * Time: 12:25 PM
 */
public class DayTest {

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                {Calendar.MONDAY, "monday"},
                {Calendar.TUESDAY, "tuesday"},
                {Calendar.WEDNESDAY, "wednesday"},
                {Calendar.THURSDAY, "thursday"},
                {Calendar.FRIDAY, "friday"},
                {Calendar.SATURDAY, "saturday"},
                {Calendar.SUNDAY, "sunday"}
        };
    }
    @DataProvider
    private Object[][] getShortTestValues() {
        return new Object[][]{
                {Calendar.MONDAY, "Mon"},
                {Calendar.TUESDAY, "Tue"},
                {Calendar.WEDNESDAY, "Wed"},
                {Calendar.THURSDAY, "Thu"},
                {Calendar.FRIDAY, "Fri"},
                {Calendar.SATURDAY, "Sat"},
                {Calendar.SUNDAY, "Sun"}
        };
    }
    @DataProvider
    private Object[][] getShortWrongValues() {
        int outOfWeekIndex = 10;
        return new Object[][]{
                {outOfWeekIndex,"Mon"},
                {outOfWeekIndex,"Tue"},
                {outOfWeekIndex,"Wed"},
                {outOfWeekIndex,"Thu"},
                {outOfWeekIndex,"Fri"},
                {outOfWeekIndex,"Sat"},
                {outOfWeekIndex,"Sun"}
        };
    }
    @DataProvider
    private Object[][] getWrongValues() {
        int outOfWeekIndex = 10;
        return new Object[][]{
                {outOfWeekIndex, "monday"},
                {outOfWeekIndex, "tuesday"},
                {outOfWeekIndex, "wednesday"},
                {outOfWeekIndex, "thursday"},
                {outOfWeekIndex, "friday"},
                {outOfWeekIndex, "saturday"},
                {outOfWeekIndex, "sunday"}
        };
    }
    @DataProvider
    private Object[][] getWrongNameValues() {
        String wrongName = "HappyDay";
        return new Object[][]{
                {Calendar.MONDAY, wrongName},
                {Calendar.TUESDAY, wrongName},
                {Calendar.WEDNESDAY, wrongName},
                {Calendar.THURSDAY, wrongName},
                {Calendar.FRIDAY, wrongName},
                {Calendar.SATURDAY, wrongName},
                {Calendar.SUNDAY, wrongName}
        };
    }
    @BeforeMethod
    public void setUp() throws Exception {

    }
    @Test(dataProvider = "getTestValues")
    public void shouldBeReturnCorrectDayNames(int dayIndex, String longName) throws Exception {
        Day sut = Day.make(dayIndex);
        assertEquals(sut.longName().toLowerCase(), longName);
    }

    @Test(dataProvider = "getWrongValues", expectedExceptions = IllegalArgumentException.class)
    public void shouldBeThrowIllegalArgumentException(int dayIndex, String longName) throws Exception {
        Day sut = Day.make(dayIndex);
        assertEquals(sut.longName().toLowerCase(), longName);
    }
    @Test(dataProvider="getShortTestValues")
    public void shouldBeReturnShortNameFromDayCode(int dayCode, String name) throws Exception {
        Day sut = Day.make(dayCode);
        assertEquals(sut.shortName(), name);
    }
    @Test(dataProvider="getShortWrongValues",expectedExceptions = IllegalArgumentException.class)
    public void shouldBeThrowExceptionUsingWrongCode(int dayCode, String name) throws Exception {
        Day sut = Day.make(dayCode);
        assertEquals(sut.shortName(), name);
    }
    @Test(dataProvider = "getTestValues")
    public void shouldBeReturnWeekdayCodeFromName(int dayCode, String name) throws Exception {
        Day sut = Day.MONDAY;
        assertEquals(sut.stringToWeekdayCode(name), dayCode);
    }
    //@Test(dataProvider = "getWrongNameValues")
    @Test(dataProvider="getWrongNameValues",  expectedExceptions = IllegalArgumentException.class)
    public void shouldBeThrowExceptionUsingWrongNames(int dayCode, String name) throws Exception {
        Day sut = Day.MONDAY;
        assertEquals(sut.stringToWeekdayCode(name), dayCode);
    }
    @Test(dataProvider = "getTestValues")
    public void shouldBeReturnNameFromDayCode(int dayCode, String name) throws Exception {
        Day sut = Day.MONDAY;
        assertEquals(sut.weekdayCodeToString(dayCode).toLowerCase(), name);
    }
    //@Test(dataProvider = "getWrongValues")
    @Test(dataProvider = "getWrongValues",  expectedExceptions = IllegalArgumentException.class)
    public void shouldBeThrowExceptionUsingWrongDayCode(int dayCode, String name) throws Exception {
        Day sut = Day.MONDAY;
        assertEquals(sut.weekdayCodeToString(dayCode).toLowerCase(), name);
    }
}
