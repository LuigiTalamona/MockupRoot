package org.talamona.chapter7.example7_5_4;

import org.talamona.chapter7.example7_4_3.SomeCollaborator;

/**
 *
 * @author luigi
 */
public class MyPartialSut {
    
    public Integer invoke(){
        SomeCollaborator c = this.createCollaborator();
        return c.makeCalc();
    }
    // extracted to emprove testing
    protected SomeCollaborator createCollaborator(){
        return new SomeCollaborator();
    }
    
}
