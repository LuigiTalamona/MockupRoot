package org.talamona.chapter4.exercise4_10_2;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class RegexNGTest {
    private Regex instance;
    
    public RegexNGTest() {
    }
    @DataProvider
    private String[][] getTestValues() {
        return new String[][]{
                    {"1234abcd", "1234"},
                    {"abcd", null},
                    {"1234abcd345","1234,345"},
                    {"1234 abcd 345 22-34567","1234,345,34567"},
        };
    }
    @DataProvider
    private Object[][] getIllegalValues() {
        return new Object[][]{
                    {null, null}
        };
    }
    @BeforeMethod
    public void setup(){
        this.instance = new Regex();
        // Run before every test method
    }
    @Test(dataProvider="getTestValues")
    public void testExtractNumbers(String input, String expected){
        System.out.println("testExtractNumbers");
        String actual = this.instance.extractNumbers(input);
        assertEquals(actual, expected);
    }
    @Test(dataProvider="getIllegalValues", expectedExceptions=NullPointerException.class)
    public void testExtractNumbersWithIllegalVals(String input, String expected){
        System.out.println("testExtractNumbersWithIllegalVals");
        String actual = this.instance.extractNumbers(input);
        assertEquals(actual, expected);
    }
}