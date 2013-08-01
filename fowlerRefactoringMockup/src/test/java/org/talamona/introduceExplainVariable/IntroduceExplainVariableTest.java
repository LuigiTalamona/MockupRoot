package org.talamona.introduceExplainVariable;

import org.talamona.replacetempQuery.ReplaceTempWithQueryBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/17/13
 * Time: 9:09 AM
 */
public class IntroduceExplainVariableTest {

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                {10d, 100d, 1100d},
                {1000d, 1d, 1075d},
                {1d, 2000d, 2100d},
                {5d, 300d, 1600d}
        };
    }
    @Test(dataProvider = "getTestValues")
    public void shouldBeCalculatePrice(double qty, double price, double result) throws Exception {
        IntroduceExplainVariable sut = new IntroduceExplainVariable(qty, price);
        double actual = sut.getPrice();
        assertEquals(actual, result);
    }
}
