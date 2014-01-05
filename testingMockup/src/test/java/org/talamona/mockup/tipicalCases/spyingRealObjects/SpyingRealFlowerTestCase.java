package org.talamona.mockup.tipicalCases.spyingRealObjects;

import org.mockito.Mockito;
import org.talamona.mockup.tipicalCases.stubbingMethodReturnedValue.Flower;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 2:34 PM
 */
public class SpyingRealFlowerTestCase {
    private final int ORIGINAL_NUMBER_OF_LEAFS = 8;
    private final int NEW_NUMBER_OF_LEAFS = 6;

    private Flower sut;

    @BeforeMethod
    public void setUp() throws Exception {
        this.sut = new Flower();
    }

    @Test
    public void shouldStubMethodAndCallRealNotStubbedMethod() {
        this.sut.setNumberOfLeaf(ORIGINAL_NUMBER_OF_LEAFS);
        Flower flowerSpy = spy(this.sut);
        doNothing().when(flowerSpy).setNumberOfLeaf(anyInt());

        flowerSpy.setNumberOfLeaf(NEW_NUMBER_OF_LEAFS);
        verify(flowerSpy, only()).setNumberOfLeaf(NEW_NUMBER_OF_LEAFS);

        assertEquals(flowerSpy.getNumberOfLeaf(), ORIGINAL_NUMBER_OF_LEAFS);
    }
}
