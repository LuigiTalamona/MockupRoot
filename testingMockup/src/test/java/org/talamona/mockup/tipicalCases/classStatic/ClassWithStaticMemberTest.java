package org.talamona.mockup.tipicalCases.classStatic;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 7/29/13
 * Time: 3:49 PM
 */

@PrepareForTest(StaticClass.class)

public class ClassWithStaticMemberTest extends PowerMockTestCase{
    private ClassWithStaticMember sut;

/*
    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }
*/
    @BeforeMethod
    public void setUp() throws Exception {
        sut = new ClassWithStaticMember();
    }

    @Test
    public void testSampleMethod() throws Exception {
        PowerMockito.mockStatic(StaticClass.class);
        Mockito.when(StaticClass.createNumber()).thenReturn(3L);

        String expected = Long.toString(3l);
        String actual = sut.sampleMethod();

        assertEquals(actual, expected);

        // Optionally verify that the static method was actually called
        verifyStatic();
        StaticClass.createNumber();




    }
}
