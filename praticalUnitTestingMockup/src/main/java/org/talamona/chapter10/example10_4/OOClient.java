package org.talamona.chapter10.example10_4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class OOClient {
    private List<IFund> funds;
    
    public OOClient(){
        funds = new ArrayList<IFund>();
        
    }
    public BigDecimal getValueOfAllFunds(){
        BigDecimal retValue = BigDecimal.ZERO;
        for(IFund f: this.funds){
            retValue = retValue.add(f.getValue());
        }
        return retValue;
    }

    public void addFund(IFund fund) {
        this.funds.add(fund);
    }
}
