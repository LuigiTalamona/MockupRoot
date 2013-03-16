/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup.isp.ok;

import java.util.Date;

/**
 *
 * @author luigi
 */
public class PortaTemporizzata extends Porta implements TimerClient{

    @Override
    public void blocca() {
        // METODO UTILE
    }

    @Override
    public void sblocca() {
        // METODO UTILE
    }

    @Override
    public boolean aperta() {
        // METODO UTILE
        return true;
    }

    public void setTimeout(Date time) {
        // METODO UTILE
    }

    public Date getTimeout() {
        // METODO UTILE
        return new Date();
    }

    public void allarme() {
        // METODO UTILE
    }

    
}
