package org.talamona.mockup.tipicalCases.internalStates;

import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 7/29/13
 * Time: 6:38 PM
 */
public class ClassWithInternalStatesTest {

    private ClassWithInternalStates sut;

    @BeforeMethod
    public void setup(){
        this.sut = new ClassWithInternalStates();
    }

    @Test
    public void testGetNumberMethodBefore() throws Exception {
        int expected = 100;
        int actual = this.sut.getNumber();
        assertEquals(actual, expected);

    }
    @Test
    public void testGetNumberMethodAfterUsingSetting() throws Exception {
        int expected = 500;
        Whitebox.setInternalState(this.sut, "number", expected);
        int actual = this.sut.getNumber();
        assertEquals(actual, expected);
    }
}
