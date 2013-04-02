package org.talamona.chapter5.exercise5_7_2;

import java.util.Date;

/**
 *
 * @author luigi
 */
public interface MessageLogger {

    public boolean logMessage(Message message);

    public boolean logMessage(String text, Date date);
    
}
