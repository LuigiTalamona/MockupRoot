/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup.dip.ko;

/**
 *
 * @author luigi
 */
public class Pulsante {
    private boolean state = false;
    private Lampada lampada = new Lampada();

    public void status(){
        this.state = !this.state;
        if (this.state){
            this.lampada.accenditi();
        }else{
            this.lampada.spegniti();
        }
        
        
    }
    
}
