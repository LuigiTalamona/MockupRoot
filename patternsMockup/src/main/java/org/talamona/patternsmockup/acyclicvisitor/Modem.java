/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.patternsmockup.acyclicvisitor;

/**
 *
 * @author luigi
 */
public interface Modem {
    public void dial(String number);
    public void hanghup();
    public void send(char c);
    public char recv();
    public void accept(ModemVisitor v);
    
}
