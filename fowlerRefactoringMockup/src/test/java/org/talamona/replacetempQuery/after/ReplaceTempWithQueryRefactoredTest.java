package org.talamona.replacetempQuery.after;

import org.talamona.replacetempQuery.ReplaceTempWithQueryBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/13/13
 * Time: 3:04 PM
 */
public class ReplaceTempWithQueryRefactoredTest {

        @DataProvider
        private Object[][] getTestValues() {
            return new Object[][]{
                    {10d, 100d, 980d},
                    {1000d, 1d, 980d},
                    {1d, 2000d, 1900d},
                    {5d, 300d, 1425d}
            };
        }
        @Test(dataProvider = "getTestValues")
        public void shouldBeCalculatePrice(double qty, double price, double result) throws Exception {
            ReplaceTempWithQueryBase sut = new ReplaceTempWithQueryBase(qty, price);
            double actual = sut.getPrice();
            assertEquals(actual, result);
        }

    }
