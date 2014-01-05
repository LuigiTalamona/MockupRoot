package org.talamona.mockup.tipicalCases.verifyingBehaviorTestCase;

import org.talamona.mockup.tipicalCases.verifyingBehavior.WaterSource;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 3:28 PM
 */
public class WaterSourceForBehaviorTest {
    private WaterSource sut;

    @BeforeMethod
    public void setUp() throws Exception {
        this.sut = mock(WaterSource.class);

    }


    @Test
    public void shouldVerifyNumbersOfCallsOnMethods(){
        this.sut.doSelfCheck();

        this.sut.getTemperature();
        this.sut.getTemperature();

        this.sut.getPressure();
        this.sut.getPressure();
        this.sut.getPressure();
        this.sut.getPressure();

        this.sut.doSelfCheck();
        this.sut.getTemperature();

        verify(this.sut, atLeastOnce()).doSelfCheck();
        verify(this.sut, atMost(2)).doSelfCheck();

        verify(this.sut, times(4)).getPressure();
        verify(this.sut, atLeast(3)).getTemperature();
        verify(this.sut, never()).calculateCapacity();


    }
}
