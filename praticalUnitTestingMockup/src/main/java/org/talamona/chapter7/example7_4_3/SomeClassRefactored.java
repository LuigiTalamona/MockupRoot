package org.talamona.chapter7.example7_4_3;

/**
 *
 * @author luigi
 */
public class SomeClassRefactored {
    private SomeCollaborator collaborator;
    
    public SomeClassRefactored(){
    }

    public SomeClassRefactored(SomeCollaborator sc){
        this.collaborator = sc;
    }
    
    
    private Boolean aMethod(Long param){
        return Boolean.TRUE;
    }
    
    public Integer secondMethod(){
        return this.collaborator.makeCalc();
    }

    public SomeCollaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(SomeCollaborator collaborator) {
        this.collaborator = collaborator;
    }
    
}
