package org.talamona.mockup.tipicalCases.privateMethod;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.times;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 7/29/13
 * Time: 4:10 PM
 */

@PrepareForTest(ClassWithPrivateMethod.class)
public class ClassWithPrivateMethodTest extends PowerMockTestCase {
    private ClassWithPrivateMethod sut;

    @BeforeMethod
    public void setup(){
        this.sut = PowerMockito.spy(new ClassWithPrivateMethod());
    }


    @Test
    public void testSampleMethod() throws Exception {
        String expected = Long.toString(100l);

        // use PowerMockito to set up your expectation
        PowerMockito.doReturn(expected).when(this.sut, "calculateNumber");
        String actual = this.sut.sampleMethod();

        // Use PowerMockito.verify() to verify result
        PowerMockito.verifyPrivate(this.sut, times(1)).invoke("calculateNumber");

        assertEquals(actual, expected);
    }

    @Test
    public void secondSampleMethodTestNG() throws Exception {
        long longValue = 300l;

        String expected = Long.toString(longValue);

        // use PowerMockito to set up your expectation
        PowerMockito.doReturn(expected).when(this.sut, "calculateNumber", Mockito.anyLong());
        String actual = this.sut.secondSampleMethod();

        // Use PowerMockito.verify() to verify result
        PowerMockito.verifyPrivate(this.sut, times(1)).invoke("calculateNumber", Mockito.anyLong());

        assertEquals(actual, expected);
    }
    @Test
    public void testPrivateMethod(){
        long longValue = 10l;
        String expected = Long.toString(longValue * 20l);
        try {
            String actual = Whitebox.<String>invokeMethod(this.sut, "calculateNumber", longValue);
            assertEquals(actual, expected);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
