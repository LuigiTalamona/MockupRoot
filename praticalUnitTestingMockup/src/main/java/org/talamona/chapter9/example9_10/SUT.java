package org.talamona.chapter9.example9_10;

/**
 *
 * @author luigi
 */
public class SUT {
    private Collaborator collaborator;
    
    public Integer useCollaborator(){
        return this.collaborator.doSomething();
        
    }
    
}
