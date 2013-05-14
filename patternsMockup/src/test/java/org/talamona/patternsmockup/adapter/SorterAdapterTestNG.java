package org.talamona.patternsmockup.adapter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 4/30/13
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SorterAdapterTestNG {
    private SorterAdapter sut;

    @BeforeMethod
    public void setUp() throws Exception {
        this.sut = new SorterAdapter();
    }

    @Test
    public void shouldBeSortUsingOneOtherInterface() throws Exception {

        int[] expected = {1, 2, 5};
        int[] unsorted = {Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(1)};
        int[] actual = sut.sort(unsorted);
        assertEquals(actual, expected);
    }
}
