package org.talamona.moveMethod.after;

import org.testng.annotations.BeforeMethod;
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

    private AccountAbstractRefactored sut;

    @BeforeMethod
    public void createSut(){
        this.sut = StandardAccountRefactored.make();
    }


    @Test
    public void shouldBeReturnAStandardAccount() throws Exception {
        boolean isStandardAccount = this.sut instanceof StandardAccountRefactored;
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
        double actual = sut.getType().overdraftCharge(sut.getDaysOverdrawn());
        assertEquals(actual, expected);
    }

}
