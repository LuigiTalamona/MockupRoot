package org.talamona.moveMethod;

import org.testng.annotations.BeforeMethod;
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
}
