package org.talamona.methodObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/25/13
 * Time: 10:38 AM
 */
public class AccountTest {


    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                {0, 2, 2000, 560},
                {5, 100, 2001, 69595},
                {12, 8, 1982, 166856},
                {3, -4, 1963, 41807},
                {7, 22, 1966, 96586},
        };
    }

    @Test(dataProvider = "getTestValues")
    public void testGamma(int i1, int i2, int i3, int result) throws Exception {

        Account sut = new Account();
        int actual = sut.gamma(i1, i2, i3);
        assertEquals(actual, result);


    }
    @Test(dataProvider = "getTestValues")
    public void testMethodObject(int i1, int i2, int i3, int result) throws Exception {


        org.talamona.methodObject.after.AccountRefactored account = new org.talamona.methodObject.after.AccountRefactored();
        org.talamona.methodObject.after.Gamma sut = new org.talamona.methodObject.after.Gamma(account, i1, i2, i3);
        int actual = sut.compute();
        assertEquals(actual, result);


    }
}
