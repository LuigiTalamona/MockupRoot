/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter6.exercise6_12_4;

import java.util.Calendar;

/**
 *
 * @author luigi
 */
public class HelpDesk {
    Calendar calendar;
    
    private final int EOB_HOUR = 17;

    public HelpDesk() {
    }

    public void setCalendar(Calendar c) {
        this.calendar = c;
        
    }
    public boolean willHandleIssue(Issue issue){
        boolean retValue = true;
        int dayOfWeek = this.calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY){
            retValue = false;
        }
        if (dayOfWeek == Calendar.FRIDAY){
            int hour = this.calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > EOB_HOUR){
                retValue = false;
            }
        }
        return retValue;
    }
}
