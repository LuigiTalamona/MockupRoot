package org.talamona.mockup.tipicalCases.stubbingMultipleCallsOnSameMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.talamona.mockup.tipicalCases.verifyingBehavior.WaterSource;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 2:34 PM
 */
public class MultipleCallsTestCase {
    private WaterSource sut;

    @BeforeTest
    public void init(){
        this.sut = mock(WaterSource.class);
        when(this.sut.calculateCapacity()).thenThrow(new RuntimeException()).thenReturn(100d);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        when(this.sut.getPressure()).thenReturn(3.0d,5.0d);
    }

    @Test(priority = 1)
    public void shouldReturnLastDefinedValueConsistently() {
        assertEquals(sut.getPressure(), 3.0d);
        assertEquals(sut.getPressure(), 5.0d);
        assertEquals(sut.getPressure(), 5.0d);
    }
    // Following methods using Stubbing consecutive calls (definied in this.init())
    // First call throw RuntimeException
    @Test(expectedExceptions = RuntimeException.class, priority = 2)
    public void shouldThrowRuntimeException() throws RuntimeException{
        sut.calculateCapacity();
    }
    // Second call return 100d
    @Test(priority = 3)
    public void shouldReturnCorrectValue() {
        assertEquals(100d, sut.calculateCapacity());
    }
}
