/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup.isp.degenere;

import java.util.Date;

/**
 *
 * @author luigi
 */
public class PortaBlindata extends Porta{

/* *********************************************************************/
/* METODI DA <<Porta>> *************************************************/
/* *********************************************************************/
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
/* *********************************************************************/
/* METODI DA <<TimerClient>> *******************************************/
/* *********************************************************************/

    public void setTimeout(Date time) {
        // METODO DEGENERE
    }

    public Date getTimeout() {
        return null;
        // METODO DEGENERE
    }

    public void allarme() {
        // METODO DEGENERE
    }

    
}
