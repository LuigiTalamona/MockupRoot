package org.talamona.moveMethod.after;

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

    private AccountAbstractRefactored sut;

    @BeforeMethod
    public void createSut(){
        this.sut = PremiumAccountRefactored.make();
    }

    @Test
    public void shouldBeReturnAPremiumAccount() throws Exception {
        boolean isPremiumAccount = this.sut instanceof PremiumAccountRefactored;
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
        double expected = 12.55d;
        double actual = sut.getType().overdraftCharge(sut.getDaysOverdrawn());
        assertEquals(actual, expected);
    }
}
