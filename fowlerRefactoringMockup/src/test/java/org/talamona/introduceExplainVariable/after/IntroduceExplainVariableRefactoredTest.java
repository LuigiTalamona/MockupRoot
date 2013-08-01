package org.talamona.introduceExplainVariable.after;

import org.talamona.introduceExplainVariable.IntroduceExplainVariable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/17/13
 * Time: 9:49 AM
 */
public class IntroduceExplainVariableRefactoredTest {
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
        IntroduceExplainVariableRefactored sut = new IntroduceExplainVariableRefactored(qty, price);
        double actual = sut.getPrice();
        assertEquals(actual, result);
    }

}
