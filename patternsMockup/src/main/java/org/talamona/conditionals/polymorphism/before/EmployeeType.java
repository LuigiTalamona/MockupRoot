/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.conditionals.polymorphism.before;

/**
 *
 * @author luigi
 */
abstract class EmployeeType {
    
    public static final int ENGINEER = 0;
    public static final int SALESMAN = 1;
    public static final int MANAGER = 2;
    
    int type;
    
    
    public EmployeeType(int type){
        this.type = type;
    }

    int getType() {
        return this.type;
    }
    
    
    
}
