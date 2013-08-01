package org.talamona.chapter7.example7_6_1;

import java.util.Date;

/**
 *
 * @author luigi
 */
public class PIM {
    private final int MILLIS_IN_MINUTE = 60 * 1000;
    private MyCalendar calendar;
    
    public PIM(MyCalendar c){
        this.calendar = c;
    }
    
    public void addMeeting(Date start, int durationTime){
        Date  endDate = new Date(start.getTime() + MILLIS_IN_MINUTE * durationTime);
        Meeting m = new Meeting(start, endDate);
        this.calendar.addEvent(m);
    }
    
}
