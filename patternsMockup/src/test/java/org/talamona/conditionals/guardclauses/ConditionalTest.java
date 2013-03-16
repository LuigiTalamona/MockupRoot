package org.talamona.conditionals.guardclauses;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class ConditionalTest {

    Conditional instance;

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                    {Conditional.Status.RETIRED, 50d},
                    {Conditional.Status.TEMPORARY, 100d},
                    {Conditional.Status.SUSPENDED, 20d},
                    {null, 500d}
        };
    }

    @BeforeMethod
    public void setup() {
        instance = new Conditional();
    }

    public void testDummy() {
        System.out.println("TestNG dummy test...");

        assertTrue(true);
    }
    
    @Test(dataProvider = "getTestValues")
    public void testDoChoiceFirstVersion(Conditional.Status status, double value) {
        System.out.println("Test getAmount that not using guard clauses...");

        instance.setStatus(status);
        assertEquals(instance.getAmount(), value);
    }
    @Test(dataProvider = "getTestValues")
    public void testDoChoiceSecondVersion(Conditional.Status status, double value) {
        System.out.println("Test getAmount that using guard clauses...");

        instance.setStatus(status);
        assertEquals(instance.getAmountRevised(), value);
    }
}
