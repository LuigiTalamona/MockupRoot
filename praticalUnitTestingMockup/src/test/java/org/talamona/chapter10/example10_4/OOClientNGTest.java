package org.talamona.chapter10.example10_4;

import java.math.BigDecimal;
import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class OOClientNGTest {
    private BigDecimal VALUE_A = BigDecimal.valueOf(9);
    private BigDecimal VALUE_B = BigDecimal.valueOf(2);

    public OOClientNGTest() {
    }

    @BeforeMethod
    public void setup(){
        // Run before every test method
    }
    
    @Test
    public void testOOClient(){
        OOClient sut = new OOClient();
        IFund fundA = Mockito.mock(IFund.class);
        IFund fundB = Mockito.mock(IFund.class);
        
        Mockito.when(fundA.getValue()).thenReturn(VALUE_A);
        Mockito.when(fundB.getValue()).thenReturn(VALUE_B);
        
        sut.addFund(fundA);
        sut.addFund(fundB);
        
        BigDecimal expected = VALUE_A.add(VALUE_B);
        BigDecimal actual = sut.getValueOfAllFunds();
        
        assertEquals(actual, expected);
    }

}