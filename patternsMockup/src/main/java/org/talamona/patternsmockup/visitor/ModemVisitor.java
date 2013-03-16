/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.visitor;

/**
 *
 * @author luigi
 */
public interface ModemVisitor {
    public void visit(HayesModem modem);
    public void visit(ZoomModem modem);
    public void visit(LuigiModem modem);
    
}
