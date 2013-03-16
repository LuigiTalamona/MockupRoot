/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.visitor;

/**
 *
 * @author luigi
 */
public class LinuxModemConfigurator implements ModemVisitor{

    public void visit(HayesModem modem) {
        modem.setConfigurationValue("&s1=4&D=3");
    }

    public void visit(ZoomModem modem) {
        modem.setConfigurationValue(42);
    }

    public void visit(LuigiModem modem) {
        modem.setConfigurationValue("No configuration");
    }
    
}
