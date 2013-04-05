package org.talamona.chapter7.example7_6_1;

import java.util.Date;

/**
 *
 * @author luigi
 */
public class Meeting implements Event{
    private Date startDate, endDate;
    
    public Meeting(Date start, Date end){
        this.startDate = new Date(start.getTime());
        this.endDate = new Date(end.getTime());
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    
}
