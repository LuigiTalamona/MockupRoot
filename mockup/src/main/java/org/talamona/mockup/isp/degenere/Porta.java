/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup.isp.degenere;

/**
 *
 * @author luigi
 */
public abstract class Porta implements TimerClient{
    public abstract void blocca();
    public abstract void sblocca();
    public abstract boolean aperta();

}
