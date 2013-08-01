package org.talamona.moveField;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/26/13
 * Time: 2:17 PM
 */
public class PremiumAccountTest {

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
        this.sut = PremiumAccount.make();
    }

    @Test
    public void shouldBeReturnAPremiumAccount() throws Exception {
        boolean isPremiumAccount = this.sut instanceof PremiumAccount;
        assertTrue(isPremiumAccount);
    }

    @Test
    public void shouldBeCalculateBankCharge() throws Exception {
        double expected = 17.05d;
        double actual = this.sut.bankCharge();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldBeCalculateOverdraftChargeOnPremium() throws Exception {
        AccountAbstract sut = PremiumAccount.make();
        double expected = 12.55d;
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
