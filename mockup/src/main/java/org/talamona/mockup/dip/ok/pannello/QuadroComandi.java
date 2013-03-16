/*
 * Quadro comandi per: 3 Lampade, 2 Motori
 */
package org.talamona.mockup.dip.ok.pannello;

import java.util.List;
import org.talamona.mockup.dip.ok.comandi.Pulsante;
import org.talamona.mockup.dip.ok.comandi.ServerPulsante;

/**
 *
 * @author luigi
 */
public class QuadroComandi {
    
    private Pulsante pulsante1, pulsante2, pulsante3, pulsante4;
    
    
    public QuadroComandi(List dispositivi){
        if (dispositivi != null){
            pulsante1 = new Pulsante((ServerPulsante)dispositivi.get(0));
            pulsante2 = new Pulsante((ServerPulsante)dispositivi.get(1));
            pulsante3 = new Pulsante((ServerPulsante)dispositivi.get(2));
            pulsante4 = new Pulsante((ServerPulsante)dispositivi.get(3));
        }
    }
}
