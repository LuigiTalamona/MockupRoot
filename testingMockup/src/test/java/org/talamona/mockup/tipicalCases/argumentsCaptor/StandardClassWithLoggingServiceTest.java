package org.talamona.mockup.tipicalCases.argumentsCaptor;

import org.apache.log4j.Logger;
import org.mockito.*;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyObject;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/7/13
 * Time: 3:26 PM
 */

@PrepareForTest({StandardClassWithLoggingService.class})
@SuppressStaticInitializationFor({"StandardClassWithLoggingService"})

public class StandardClassWithLoggingServiceTest {

    @Mock private Logger logger;
    @Mock private StandardClassWithLoggingService sut;

    @Captor private ArgumentCaptor<Object> argumentCaptor;

    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
        Whitebox.setInternalState(sut, "logger", logger);
    }
    @Test
    public void testDoSomethingWithNoparamsWritingLogs() throws Exception {
        Mockito.when(this.sut.doSomethingWithNoparamsWritingLogs()).thenCallRealMethod();
        boolean actual = this.sut.doSomethingWithNoparamsWritingLogs();

        Mockito.verify(logger).info(argumentCaptor.capture());
        Object message = argumentCaptor.getValue();
        System.out.println(message);

        Mockito.verify(logger).warn(argumentCaptor.capture());
        message = argumentCaptor.getValue();
        System.out.println(message);

        Mockito.verify(logger).error(argumentCaptor.capture());
        message = argumentCaptor.getValue();
        System.out.println(message);

        Mockito.verify(logger).debug(argumentCaptor.capture());
        message = argumentCaptor.getValue();
        System.out.println(message);

        assertEquals(actual, true);

    }
}
