package org.talamona.mockup.tipicalCases.classStatic;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.testng.Assert.assertEquals;

import org.powermock.modules.testng.PowerMockTestCase;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 7/29/13
 * Time: 3:49 PM
 */

@PrepareForTest(StaticClass.class)

public class ClassWithStaticMemberTest extends PowerMockTestCase {
    private final long TEST_VALUE = 3L;
    private ClassWithStaticMember sut;

    @BeforeMethod
    public void setUp() throws Exception {
        sut = new ClassWithStaticMember();
    }
    @Test
    public void testSampleMethod() throws Exception {
        mockStatic(StaticClass.class);
        when(StaticClass.createNumber()).thenReturn(TEST_VALUE);

        String expected = Long.toString(TEST_VALUE);
        String actual = sut.sampleMethod();
        assertEquals(actual, expected);

        // Optionally verify that the static method was actually called
        verifyStatic(times(1));
        StaticClass.createNumber();

    }
}
