package org.talamona.mockup.tipicalCases.stubbingReturningVoidMethod;

import org.talamona.mockup.tipicalCases.stubbingMethodReturnedValue.Flower;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 3:08 PM
 */
public class StubbingVoidMethodWithExceptionTestCase {
    ArrayList sut;

    @BeforeMethod
    public void setup(){
        this.sut = mock(ArrayList.class);
        doThrow(new RuntimeException("Error")).when(this.sut).clear();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void thisTestMustBeThrowRuntimeException(){
        this.sut.clear();
    }
}
