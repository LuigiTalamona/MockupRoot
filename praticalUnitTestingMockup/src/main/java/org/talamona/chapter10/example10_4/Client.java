package org.talamona.chapter10.example10_4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class Client {
    private List<IFund> funds;
    
    public Client(){
        funds = new ArrayList<IFund>();
        
    }
    public BigDecimal getValueOfAllFunds(){
        BigDecimal retValue = BigDecimal.ZERO;
        for(IFund f: this.funds){
            BigDecimal multiplier = new BigDecimal(f.getRegisterX().getNbOfUnits() + f.getRegisterY().getNbOfUnits());
            retValue = retValue.add(f.getCurrentValue().getValue().multiply(multiplier));
        }
        return retValue;
    }

    public void addFund(IFund fund) {
        this.funds.add(fund);
    }
}
