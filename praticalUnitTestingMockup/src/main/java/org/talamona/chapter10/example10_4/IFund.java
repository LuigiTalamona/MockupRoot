package org.talamona.chapter10.example10_4;

import java.math.BigDecimal;

/**
 *
 * @author luigi
 */
public interface IFund {

    public IRegister getRegisterY();

    public IRegister getRegisterX();

    public ICurrentValue getCurrentValue();

    public BigDecimal getValue();
    
}
