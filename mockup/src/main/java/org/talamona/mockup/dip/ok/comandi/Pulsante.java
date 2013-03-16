/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup.dip.ok.comandi;

/**
 *
 * @author luigi
 */
public class Pulsante {
    private boolean state = false;
    private ServerPulsante dispositivo;
    
    public Pulsante(ServerPulsante d){
        this.dispositivo = d;
    }

    public void status(){
        this.state = !this.state;
        if (this.state){
            this.dispositivo.accenditi();
        }else{
            this.dispositivo.spegniti();
        }
    }
}
