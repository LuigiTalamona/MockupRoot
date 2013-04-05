package org.talamona.chapter7.example7_4_3;

/**
 *
 * @author luigi
 */
public class SomeClass {
    
    private Boolean aMethod(Long param){
        return Boolean.TRUE;
    }
    
    public Integer secondMethod(){
        SomeCollaborator c = new SomeCollaborator();
        
        return c.makeCalc();
    }
    
}
