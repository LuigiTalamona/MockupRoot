package org.talamona.chapter3.exercise3_11_2;

/**
 *
 * @author luigi
 */
class EmptyStringException extends Exception {
    
    public EmptyStringException(){}
    public EmptyStringException(String message){
        super(message);
    }
    
}
