package org.talamona.chapter9.exercise9_10_2;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class TransactionNGTest {

    public TransactionNGTest() {
    }

    @BeforeMethod
    public void setup(){
    }
    
    @Test
    public void testDataBuilder(){
        System.out.println(this.getClass().getCanonicalName() + ".testDataBuilder");
        Transaction sut = new TransactionBuilder().withId(100l).withState("").
                withRetryAllowed(true).withMessage("aMessage").
                withBillingId("ID").build();
        
        
        
        assertNotNull(sut);
    }
}