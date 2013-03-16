/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.acyclicvisitor;

/**
 *
 * @author luigi
 */
public class OSxModemConfigurator implements HayesVisitor, ZoomVisitor, LuigiVisitor{

    public void visit(HayesModem modem) {
        modem.setConfigurationValue("&s1=8&D=3&M=1 - acyclic");
    }

    public void visit(ZoomModem modem) {
        modem.setConfigurationValue(62);
    }

    public void visit(LuigiModem modem) {
        modem.setConfigurationValue("configuration for OSx Lion - acyclic");
    }
    
}
