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
public class ClientNGTest {
    private Integer NB_OF_UNITS_AX = 5;
    private Integer NB_OF_UNITS_AY = 1;
    private Integer NB_OF_UNITS_BX = 4; 
    private Integer NB_OF_UNITS_BY = 1;
    private BigDecimal FUND_A_VALUE = BigDecimal.valueOf(3l);
    private BigDecimal FUND_B_VALUE = BigDecimal.valueOf(2l);

    public ClientNGTest() {
    }
    @BeforeMethod
    public void setup(){
        // Run before every test method
    }
    @Test
    public void testClient() {
        System.out.println(this.getClass().getCanonicalName() + ".testClient()");
        Client sut = new Client();
        IFund fundA = Mockito.mock(IFund.class);
        IFund fundB = Mockito.mock(IFund.class);
        
        IRegister regAX = Mockito.mock(IRegister.class);
        IRegister regBX = Mockito.mock(IRegister.class);
        IRegister regAY = Mockito.mock(IRegister.class);
        IRegister regBY = Mockito.mock(IRegister.class);
        
        ICurrentValue currentValueA = Mockito.mock(ICurrentValue.class);
        ICurrentValue currentValueB = Mockito.mock(ICurrentValue.class);
        
        Mockito.when(fundA.getRegisterX()).thenReturn(regAX);
        Mockito.when(fundA.getRegisterY()).thenReturn(regAY);
        
        Mockito.when(fundB.getRegisterX()).thenReturn(regBX);
        Mockito.when(fundB.getRegisterY()).thenReturn(regBY);
        
        Mockito.when(regAX.getNbOfUnits()).thenReturn(NB_OF_UNITS_AX);
        Mockito.when(regAY.getNbOfUnits()).thenReturn(NB_OF_UNITS_AY);

        Mockito.when(regBX.getNbOfUnits()).thenReturn(NB_OF_UNITS_BX);
        Mockito.when(regBY.getNbOfUnits()).thenReturn(NB_OF_UNITS_BY);
        
        Mockito.when(fundA.getCurrentValue()).thenReturn(currentValueA);
        Mockito.when(fundB.getCurrentValue()).thenReturn(currentValueB);

        Mockito.when(currentValueA.getValue()).thenReturn(FUND_A_VALUE);
        Mockito.when(currentValueB.getValue()).thenReturn(FUND_B_VALUE);
        
        sut.addFund(fundA);
        sut.addFund(fundB);
        
        BigDecimal actual = sut.getValueOfAllFunds();
        
        BigDecimal expected = BigDecimal.valueOf((5 +1) * 3 + (4 +1) * 2);
        assertEquals(actual, expected);
    }

}