package org.talamona.mockup.tipicalCases.argumentsCaptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/7/13
 * Time: 3:18 PM
 */
public class StandardClassWithLoggingService {

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(StandardClassWithLoggingService.class);

    public StandardClassWithLoggingService(){

    }
    public boolean doSomethingWithNoparamsWritingLogs(){
        String dateFormatedd = getFormattedDate();
        logger.info("info log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        logger.warn("warning log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        logger.error("error log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        logger.debug("debug log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        return true;
    }


    public boolean doSomethingWithParamsWritingLogs(String string){
        String dateFormatedd = getFormattedDate();
        logger.info("info log wrote on " + dateFormatedd + this.prepareLogMessage(string));
        logger.warn("info log wrote on " + dateFormatedd + this.prepareLogMessage(string));
        logger.error("info log wrote on " + dateFormatedd + this.prepareLogMessage(string));
        logger.debug("info log wrote on " + dateFormatedd + this.prepareLogMessage(string));
        return true;
        
        
    }
    private String prepareLogMessage(String string){
        return " by method doSomethingWithParamsWritingLogs(" + string + ") of " +  this.getClass().getCanonicalName();
    }
    private String getFormattedDate() {
        Calendar date = Calendar.getInstance(Locale.ITALY);
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.FULL, Locale.ITALY);
        df.applyPattern("dd MMMMM yyyy hh:mm:ss");
        return df.format(date.getTime());
    }
}
