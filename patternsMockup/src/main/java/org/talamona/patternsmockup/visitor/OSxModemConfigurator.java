/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.visitor;

/**
 *
 * @author luigi
 */
public class OSxModemConfigurator implements ModemVisitor{

    public void visit(HayesModem modem) {
        modem.setConfigurationValue("&s1=8&D=3&M=1");
    }

    public void visit(ZoomModem modem) {
        modem.setConfigurationValue(52);
    }

    public void visit(LuigiModem modem) {
        modem.setConfigurationValue("configuration for OSx Lion");
    }
    
}
