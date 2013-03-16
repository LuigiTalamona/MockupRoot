/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup.dip.ko;

/**
 *
 * @author luigi
 */
class Lampada {
    private int status = 0;
    public void accenditi(){
        status = 1;
    }
    public void spegniti(){
        status = 2;
    }
}
