/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.acyclicvisitor;

/**
 *
 * @author luigi
 */
public class LinuxModemConfigurator implements HayesVisitor, ZoomVisitor, LuigiVisitor{

    public void visit(HayesModem modem) {
        modem.setConfigurationValue("&s1=4&D=3 - acyclic");
    }

    public void visit(ZoomModem modem) {
        modem.setConfigurationValue(62);
    }

    public void visit(LuigiModem modem) {
        modem.setConfigurationValue("No configuration - acyclic");
    }
    
}
