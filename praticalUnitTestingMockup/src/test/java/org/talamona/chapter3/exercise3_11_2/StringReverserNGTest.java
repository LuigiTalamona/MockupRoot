package org.talamona.chapter3.exercise3_11_2;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class StringReverserNGTest {

    private StringReverser instance;

    public StringReverserNGTest() {
    }

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                    {"ABCDEFG", "GFEDCBA"},
                    {"Luigi", "igiuL"},
                    {"Anna", "annA"},
                    {"",""}};
    }
    @DataProvider
    private Object[][] getIllegalTestValues() {
        return new Object[][]{
                    {null, "GFEDCBA"},
                    {null, null}
        };
    }

    @BeforeMethod
    private void setup() {
        this.instance = new StringReverser();

    }

    @Test(dataProvider = "getTestValues")
    public void testDoReverse(String input, String expected) {
            System.out.println("doReverse");
            String result = instance.doReverse(input);
            assertEquals(result, expected);
    }

    @Test(dataProvider = "getIllegalTestValues", expectedExceptions = NullPointerException.class)
    public void testDoReverseWithIllegal(String input, String expected) {
            System.out.println("doReverse with illegal input values");
            String result = instance.doReverse(input);
            assertEquals(result, expected);
            
    }
}
