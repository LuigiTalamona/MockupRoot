package org.talamona.mockup.tipicalCases.verifyingWithTimeout;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 3:45 PM
 */

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.mockito.exceptions.base.MockitoAssertionError;
import static org.mockito.Mockito.*;

import org.talamona.mockup.tipicalCases.verifyingBehavior.RunnableWaterSource;
import org.talamona.mockup.tipicalCases.verifyingBehavior.WaterSource;

public class WaterSourceForVerifyingTimeoutTest {

    private final int TIMEFRAME_15SEC = 15000;
    private final long TIMEOUT_20SEC = 20l;
    private final int TIMEFRAME_30SEC = 30000;
    private  WaterSource sut;

    @BeforeMethod
    public void setup(){
        this.sut = mock(WaterSource.class);
    }
    @Test
    public void shouldFailForLateCall() {
        this.createAndStartThreadUnderTest(TIMEOUT_20SEC);
        verify(this.sut, never()).doSelfCheck();
        try {
            verify(this.sut, timeout(TIMEFRAME_15SEC)).doSelfCheck();
        } catch (MockitoAssertionError e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void shouldNoCallsInTooNarrowTimeFrame() {
        this.createAndStartThreadUnderTest(TIMEOUT_20SEC);
        verify(this.sut, never()).doSelfCheck();
        verify(this.sut, timeout(TIMEFRAME_15SEC).never()).doSelfCheck();
    }
    @Test
    public void shouldBeOneCallInLargerTimeFrame() {
        this.createAndStartThreadUnderTest(TIMEOUT_20SEC);
        verify(this.sut, never()).doSelfCheck();
        verify(this.sut, timeout(TIMEFRAME_30SEC).only()).doSelfCheck();
    }

    private void createAndStartThreadUnderTest(long timeout) {
        this.waitAndCallSelfCheck(this.sut, timeout).start();
    }
    private Thread waitAndCallSelfCheck(WaterSource waterSource, long timeout) {
        return RunnableWaterSource.createRunnableWaterSource(waterSource, timeout);
    }
}
