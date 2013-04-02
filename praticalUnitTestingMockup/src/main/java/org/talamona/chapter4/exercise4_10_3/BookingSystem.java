/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter4.exercise4_10_3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author luigi
 */
class BookingSystem {

    List bookedHours;
    
    public BookingSystem(){
        this.bookedHours = new ArrayList();
    }
    
    public Integer[] getBookedHours() {
        Iterator i = this.bookedHours.iterator();
        Integer[] retValue = new Integer[this.bookedHours.size()];
        Calendar c = null;
        int index = 0;
        while(i.hasNext()){
            c = (Calendar)i.next();
            retValue[index] = c.get(Calendar.HOUR);
        }
        return retValue;
    }

    public boolean makeBooking(Calendar c) {
        boolean retValue = false;
        if (this.isFreeHour(c)){
            retValue = this.bookedHours.add(c);
        }
        return retValue;
        
    }

    private boolean isFreeHour(Calendar c) {
        boolean retValue = true;
        
        int hour = c.get(Calendar.HOUR);
        Iterator i = this.bookedHours.iterator();
        Calendar temp = null;
        int tempHour = 0;
        while(i.hasNext()){
            temp = (Calendar)i.next();
            tempHour = temp.get(Calendar.HOUR);
            retValue = !(tempHour == hour);
            if (!retValue){
                break;
            }
        }
        return retValue;
    }
    
}
