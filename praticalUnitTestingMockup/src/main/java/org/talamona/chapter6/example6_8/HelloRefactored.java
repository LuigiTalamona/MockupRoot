package org.talamona.chapter6.example6_8;

import java.util.Calendar;

/**
 *
 * @author luigi
 */
public class HelloRefactored {
    private TimeProvider timeProvider;
    
    public HelloRefactored(){
    }
    public HelloRefactored(TimeProvider tp){
        this.timeProvider = tp;
    }
    public String sayHello(){
        Calendar c = this.timeProvider.getTime();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if (hour < 12){
            return "Good Morning";
        } else{
            return "Good Afternoon";
        }
    }
    
}
