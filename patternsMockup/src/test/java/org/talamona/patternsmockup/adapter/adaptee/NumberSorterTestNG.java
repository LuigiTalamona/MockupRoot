package org.talamona.patternsmockup.adapter.adaptee;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 4/29/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class NumberSorterTestNG {
    @Test
    public void shouldBeSorted() throws Exception {
        NumberSorter sut = new NumberSorter();

        List expected = Arrays.asList(1, 2, 5);
        List unsorted = Arrays.asList(Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(1));

        List actual = sut.sort(unsorted);

        assertEquals(actual, expected);






    }
}
