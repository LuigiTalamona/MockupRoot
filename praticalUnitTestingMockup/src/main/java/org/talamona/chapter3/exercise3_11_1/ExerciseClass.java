/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter3.exercise3_11_1;

/**
 *
 * @author luigi
 */
public class ExerciseClass {
    
    private String name;
    
    public ExerciseClass(String name){
        this.name = name;
    }
    public String doHelloWorld(){
        return "Hello World by " + this.name;
    }
    
}
