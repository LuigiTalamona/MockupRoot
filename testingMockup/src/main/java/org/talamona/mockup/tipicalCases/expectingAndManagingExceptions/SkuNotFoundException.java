package org.talamona.mockup.tipicalCases.expectingAndManagingExceptions;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/4/14
 * Time: 3:37 PM
 */
public class SkuNotFoundException extends Exception {
    public SkuNotFoundException(){

    }
    public SkuNotFoundException(String message){
        super(message);
    }
}
