/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.acyclicvisitor;

/**
 *
 * @author luigi
 */
public interface HayesVisitor extends ModemVisitor{
    public void visit(HayesModem m);
    
}
