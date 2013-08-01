package org.talamona.chapter7.example7_4_3;

/**
 *
 * @author luigi
 */
public class SomeClassRefactored2 {
    
    private Boolean aMethod(Long param){
        return Boolean.TRUE;
    }
    
    public Integer secondMethod(){
        SomeCollaborator c = this.createCollaborator();
        return c.makeCalc();
    }
    // extracted to emprove testing
    protected SomeCollaborator createCollaborator(){
        return new SomeCollaborator();
    }
    
}
