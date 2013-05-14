package org.talamona.conditionals.polymorphism.after;

/**
 *
 * @author luigi
 */
public abstract class EmployeeType {
    
    public enum Type{
        ENGINEER, SALESMAN, MANAGER;
    }
    
    /* Sostituito da un enum
    public static final int ENGINEER = 0;
    public static final int SALESMAN = 1;
    public static final int MANAGER = 2;
    */
    
    private Type type;
    
    
    public EmployeeType(){
        
    }

    // Questo metodo viene implementato nelle classi derivate    
    public abstract int payAmount(Employee e);
    /*
    public int payAmount(Employee e) {
        int retValue = 0;
        
        switch(type){
            case (Type.ENGINEER):{
                throw new RuntimeException("Dovrebbe essere riscritto in Engineer.class");
            }
            case (Type.SALESMAN):{
                throw new RuntimeException("Dovrebbe essere riscritto in SalesMan.class");
            }
            case (Type.MANAGER):{
                throw new RuntimeException("Dovrebbe essere riscritto in Manager.class");
            }
            
        }
        return retValue;
    }*/

    
    
    
}
