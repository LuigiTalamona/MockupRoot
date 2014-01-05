package org.talamona.mockup.tipicalCases.argumentsCaptor;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.mockito.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/7/13
 * Time: 3:26 PM
 */


public class StandardClassWithLoggingServiceAppenderTest {

    @Mock private Appender appender;
    @Captor private ArgumentCaptor<LoggingEvent> argumentCaptor;

    private StandardClassWithLoggingService sut;

    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.sut = new StandardClassWithLoggingService();
        Logger.getRootLogger().addAppender(this.appender);
    }
    @AfterMethod
    public void dispose(){
        Logger.getRootLogger().removeAppender(this.appender);
        Mockito.reset(this.appender);
    }
    @Test
    public void testDoSomethingWithNoparamsWritingLogs() throws Exception {
        boolean actual = this.sut.doSomethingWithNoparamsWritingLogs();
        Mockito.verify(this.appender, Mockito.times(4)).doAppend(this.argumentCaptor.capture());
        System.out.println(this.readArgumentCaptureValues());
        assertEquals(actual, true);
    }
    @Test
    public void testDoSomethingWithParamsWritingLogs() throws Exception {
        boolean actual = this.sut.doSomethingWithParamsWritingLogs("TEST STRING PARAM");
        Mockito.verify(this.appender, Mockito.times(4)).doAppend(this.argumentCaptor.capture());
        System.out.println(this.readArgumentCaptureValues());
        assertEquals(actual, true);

    }
    private String readArgumentCaptureValues() {
        StringBuilder sb = new StringBuilder();
        Iterator iterator = this.argumentCaptor.getAllValues().iterator();
        LoggingEvent le = null;
        while(iterator.hasNext()){
            le = (LoggingEvent)iterator.next();
            sb.append(le.getMessage() + System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
