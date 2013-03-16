/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.visitor;

/**
 *
 * @author luigi
 */
public class HayesModem implements Modem{
    
    private String configurationValue;

    public void dial(String number) {
        
    }

    public void hanghup() {
    }

    public void send(char c) {
    }

    public char recv() {
        return '0';
    }

    public void accept(ModemVisitor v) {
        v.visit(this);
    }

    /**
     * @return the configurationValue
     */
    public String getConfigurationValue() {
        return configurationValue;
    }

    /**
     * @param configurationValue the configurationValue to set
     */
    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }
    
}
