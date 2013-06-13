package org.talamona.refactoringSerialDate.org.jfree.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
* Created with IntelliJ IDEA.
* User: luigi
* Date: 5/29/13
* Time: 11:01 AM
*/
public enum Day {
    MONDAY(Calendar.MONDAY),
    TUESDAY(Calendar.TUESDAY),
    WEDNESDAY(Calendar.WEDNESDAY),
    THURSDAY(Calendar.THURSDAY),
    FRIDAY(Calendar.FRIDAY),
    SATURDAY(Calendar.SATURDAY),
    SUNDAY(Calendar.SUNDAY);

    private final int value;
    private final String longName;
    private final String shortName;

    Day(int dayIndex){
        this.value = dayIndex;
        this.longName = this.findLongName(dayIndex);
        this.shortName = this.findShortName(dayIndex);
    }

    Day(int dayIndex, String longName, String shortName){
        this.value = dayIndex;
        this.shortName = shortName;
        this.longName = longName;
    }

    public static Day make(int dayIndex){
        for(Day d: Day.values()){
            if (d.value == dayIndex){
                return d;
            }
        }
        throw new IllegalArgumentException("Illegal day index " + dayIndex);
    }

    public int value(){
        return this.value;
    }

    public String longName(){
        return this.longName;
    }

    public String shortName(){
        return this.shortName;
    }

    public int stringToWeekdayCode(final String s) {
        String trimmedS = s.trim();
        for (Day d: this.values()){
            if (d.longName().equalsIgnoreCase(trimmedS) || d.shortName().equalsIgnoreCase(trimmedS)){
                return d.value();
            }
        }
        throw new IllegalArgumentException("Illegal day name " + s);
/*


        int retValue = -1;
        SimpleDateFormat df = new SimpleDateFormat();
        String[] shortWeekdayNames = df.getDateFormatSymbols().getShortWeekdays();
        String[] weekDayNames = df.getDateFormatSymbols().getWeekdays();

        s = s.trim();
        for (int i = 0; i < weekDayNames.length; i++) {
            if (s.equals(shortWeekdayNames[i]) || s.equals(weekDayNames[i])) {
                retValue = i;
                break;
            }
        }
        return retValue;
*/
    }

    public String weekdayCodeToString(final int weekDay) {
        for (Day d: this.values()){
            if (d.value() == weekDay){
                return d.longName();
            }
        }
        throw new IllegalArgumentException("Illegal day index " + weekDay);
    }

    private String findLongName(int index){
        String[] weekDayNames = new SimpleDateFormat().getDateFormatSymbols().getWeekdays();
        if (this.verifyIndex(index, weekDayNames)){
            return weekDayNames[index];
        }
        throw new IllegalArgumentException("Illegal day index " + index);
    }

    private String findShortName(int index){
        String[] shortWeekdayNames = new SimpleDateFormat().getDateFormatSymbols().getShortWeekdays();
        if (this.verifyIndex(index, shortWeekdayNames)){
            return shortWeekdayNames[index];
        }
        throw new IllegalArgumentException("Illegal day index " + index);
    }

    private boolean verifyIndex(int index, String[] names){
        return (index >= 0 && index < names.length);
    }
}
