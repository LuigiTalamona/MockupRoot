package org.talamona.chapter7.example7_6_2;

import java.util.Date;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.talamona.chapter7.example7_6_1.Meeting;
import org.talamona.chapter7.example7_6_1.MyCalendar;
import org.talamona.chapter7.example7_6_1.PIM;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class PIMTestNG {
    private final int ONE_HOUR = 60;
    private final Date START_DATE = new Date();
    private final int MILLIS_IN_MINUTE = 1000 * 60;
    private final Date END_DATE = new Date(START_DATE.getTime() + ONE_HOUR * MILLIS_IN_MINUTE);
    

    public PIMTestNG() {
    }

    @BeforeMethod
    public void setup(){
        // Run before every test method
    }
    
    @Test
    public void shouldAddEventToCalendar(){
        MyCalendar calendar = Mockito.mock(MyCalendar.class);
        PIM pim = new PIM(calendar);
        ArgumentCaptor<Meeting> argument = ArgumentCaptor.forClass(Meeting.class);
        
        pim.addMeeting(START_DATE, ONE_HOUR);
        Mockito.verify(calendar).addEvent(argument.capture());
        Meeting meeting = argument.getValue();
        
        assertEquals(meeting.getStartDate(), START_DATE);
        assertEquals(meeting.getEndDate(), END_DATE);
    }
}