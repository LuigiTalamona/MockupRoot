package org.talamona.refactoringSerialDate.org.jfree.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/28/13
 * Time: 4:23 PM
 */
public class SpreadsheetDateFactory extends DayDateFactory {

    @Override
    public DayDate makeDate(int ordinal) {
        return new SpreadDate(ordinal);
    }

    @Override
    public DayDate makeDate(int day, DayDate.Month month, int year) {
        return this.makeDate(day, month.value, year);
    }

    @Override
    public DayDate makeDate(int day, int month, int year) {
        return new SpreadDate(day, month, year);
    }

    @Override
    public DayDate makeDate(Date date) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(date);
        return this.makeDate(c.get(Calendar.DATE), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
    }

    @Override
    public int getMinimumYear() {
        return SpreadDate.MINIMUM_YEAR_SUPPORTED;
    }

    @Override
    public int getMaximumYear() {
        return SpreadDate.MAXIMUM_YEAR_SUPPORTED;
    }
}
