package org.talamona.mockup.tipicalCases.stubbingMethodReturnedValue;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 2:34 PM
 */
public class FlowerTest {
    private static final int MODIFIED_NUMBER_OF_LEAF = 20;
    private final int DEFAULT_LEAF_VALUE = 10;
    private Flower sut;
    private int expected;

    @BeforeMethod
    public void setUp() throws Exception {
        this.sut = Mockito.mock(Flower.class);
        when(this.sut.getNumberOfLeaf()).thenReturn(DEFAULT_LEAF_VALUE);
    }

    @Test
    public void shouldReturnAlwaysDefaultLeafValue() throws Exception {
        assertEquals(this.sut.getNumberOfLeaf(), DEFAULT_LEAF_VALUE);
    }

    @Test
    public void ShouldSetAndReturnModifiedNumberOfLeaf() throws Exception {
        doCallRealMethod().when(this.sut).setNumberOfLeaf(anyInt());
        when(this.sut.getNumberOfLeaf()).thenCallRealMethod();
        this.sut.setNumberOfLeaf(MODIFIED_NUMBER_OF_LEAF);
        assertEquals(this.sut.getNumberOfLeaf(), MODIFIED_NUMBER_OF_LEAF);
    }
}
