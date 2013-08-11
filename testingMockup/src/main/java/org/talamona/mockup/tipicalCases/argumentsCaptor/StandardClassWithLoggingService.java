package org.talamona.mockup.tipicalCases.argumentsCaptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        Calendar date = Calendar.getInstance(Locale.ITALY);
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.FULL, Locale.ITALY);


        df.applyPattern("dd MMMMM yyyy hh:mm:ss");
        String dateFormatedd = df.format(date.getTime());




        logger.info("info log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        logger.warn("warning log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        logger.error("error log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        logger.debug("debug log wrote on " + dateFormatedd + " by " + this.getClass().getCanonicalName());
        return true;
    }
}
