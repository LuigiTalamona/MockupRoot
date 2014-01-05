package org.talamona.mockup.tipicalCases.stubbingReturningVoidMethod;

import org.talamona.mockup.tipicalCases.stubbingMethodReturnedValue.Flower;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 3:08 PM
 */
public class FlowerTest {
    Flower sut;

    @BeforeMethod
    public void setup(){
        this.sut = mock(Flower.class);
        when(this.sut.getNumberOfLeaf()).thenReturn(15);
    }

    @Test
    public void thisTestMustBeFail() throws Exception {
        this.sut.setNumberOfLeaf(12);
        assertNotEquals(this.sut.getNumberOfLeaf(), 12);
    }
    @Test
    public void thisTestShouldBeCorrect() throws Exception {
        doCallRealMethod().when(this.sut).setNumberOfLeaf(anyInt());
        when(this.sut.getNumberOfLeaf()).thenCallRealMethod();
        this.sut.setNumberOfLeaf(12);
        assertEquals(this.sut.getNumberOfLeaf(), 12);
    }
}
