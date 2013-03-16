package org.talamona.mockup.dip.ok.dispositivi;

import org.talamona.mockup.dip.ok.comandi.ServerPulsante;

/**
 *
 * @author luigi
 */
class Motore implements ServerPulsante{
    private int status = 0;

    public void accenditi() {
        this.status = 1;
    }
    public void spegniti() {
        this.status = 2;
    }
}
