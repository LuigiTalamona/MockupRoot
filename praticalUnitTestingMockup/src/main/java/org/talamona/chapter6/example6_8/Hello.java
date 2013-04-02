/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter6.example6_8;

import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author luigi
 */
public class Hello {
    
    
    public Hello(){}
    public String sayHello(){
        Calendar c = Calendar.getInstance(Locale.ITALIAN);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if (hour < 12){
            return "Good Morning";
        } else{
            return "Good Afternoon";
        }
    }
    
}
