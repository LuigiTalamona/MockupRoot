package org.talamona.moveField;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/27/13
 * Time: 9:11 AM
 */
public class StandardAccountTest {

    private AccountAbstract sut;

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {1d, 1000, 5d, 10d},
                {-10d, 100, 4d, -0d}
        };
    }

    @BeforeMethod
    public void createSut(){
        this.sut = StandardAccount.make();
    }


    @Test
    public void shouldBeReturnAStandardAccount() throws Exception {
        boolean isStandardAccount = this.sut instanceof StandardAccount;
        assertTrue(isStandardAccount);
    }

    @Test
    public void shouldBeCalculateBankCharge() throws Exception {
        double expected = 10.75d;
        double actual = this.sut.bankCharge();
        assertEquals(actual, expected);
    }
    @Test
    public void shouldBeCalculateOverdraftChargeOnStandard() throws Exception {
        double expected = 8.75d;
        double actual = sut.overdraftCharge();
        assertEquals(actual, expected);
    }
    @Test(dataProvider = "getData")
    public void shouldBeCalculateInterestForAmountDays(double amount, int days, double interestRate, double result)  throws Exception {
        sut.setInterestRate(interestRate);
        double actual = sut.interestForAmountDays(amount,days);
        assertEquals(actual, result);
    }

}
