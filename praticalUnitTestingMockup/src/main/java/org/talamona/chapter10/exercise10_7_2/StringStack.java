/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter10.exercise10_7_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class StringStack implements Stack{
    private List elements;
    
    public StringStack(){
        this.elements = new ArrayList();
    }

    @Override
    public void push(String value) {
        this.elements.add(value);
        
    }

    @Override
    public String pop() {
        String retValue = null;
        int index = this.elements.size() - 1;
        if(index >= 0){
            retValue = ((String) this.elements.remove(index));
        }
        return retValue;
    }
}
