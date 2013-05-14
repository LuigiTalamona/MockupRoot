package org.talamona.comments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class GeneratePrimesNGTest {

    public GeneratePrimesNGTest() {
    }

    @DataProvider
    private Object[][] getTestValues() {
        List firstPrimesInTen = new ArrayList();
        firstPrimesInTen.add(Integer.valueOf(2));
        firstPrimesInTen.add(Integer.valueOf(3));
        firstPrimesInTen.add(Integer.valueOf(5));
        firstPrimesInTen.add(Integer.valueOf(7));

        List firstPrimesInHundred = new ArrayList();
        firstPrimesInHundred.add(Integer.valueOf(2));
        firstPrimesInHundred.add(Integer.valueOf(3));
        firstPrimesInHundred.add(Integer.valueOf(5));
        firstPrimesInHundred.add(Integer.valueOf(7));
        firstPrimesInHundred.add(Integer.valueOf(11));
        firstPrimesInHundred.add(Integer.valueOf(13));
        firstPrimesInHundred.add(Integer.valueOf(17));
        firstPrimesInHundred.add(Integer.valueOf(19));
        firstPrimesInHundred.add(Integer.valueOf(23));
        firstPrimesInHundred.add(Integer.valueOf(29));
        firstPrimesInHundred.add(Integer.valueOf(31));
        firstPrimesInHundred.add(Integer.valueOf(37));
        firstPrimesInHundred.add(Integer.valueOf(41));
        firstPrimesInHundred.add(Integer.valueOf(43));
        firstPrimesInHundred.add(Integer.valueOf(47));
        firstPrimesInHundred.add(Integer.valueOf(53));
        firstPrimesInHundred.add(Integer.valueOf(59));
        firstPrimesInHundred.add(Integer.valueOf(61));
        firstPrimesInHundred.add(Integer.valueOf(67));
        firstPrimesInHundred.add(Integer.valueOf(71));
        firstPrimesInHundred.add(Integer.valueOf(73));
        firstPrimesInHundred.add(Integer.valueOf(79));
        firstPrimesInHundred.add(Integer.valueOf(83));
        firstPrimesInHundred.add(Integer.valueOf(89));
        firstPrimesInHundred.add(Integer.valueOf(97));

        return new Object[][]{
                    {Integer.valueOf(10), firstPrimesInTen},
                    {Integer.valueOf(100), firstPrimesInHundred}
                };
    }

    @BeforeMethod
    public void setup() {
        // Run before every test method
    }

    @Test(dataProvider = "getTestValues")
    public void shouldBeGeneratePrimes(Integer maxValue, List expectedPrimes) {
        System.out.println(this.getClass().getCanonicalName() + ".shouldBeGeneratePrimes()");

        int[] actualResults = GeneratePrimes.generatePrimes(maxValue);
        assertEquals(actualResults, expectedPrimes.toArray());
    }
}