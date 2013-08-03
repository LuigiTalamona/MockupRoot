package org.talamona.mockup.tipicalCases.privateMethod;


/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 7/29/13
 * Time: 3:44 PM
 */
public class ClassWithPrivateMethod {


    public String sampleMethod(){
        return this.calculateNumber();
    }
    public String secondSampleMethod(){
        return this.calculateNumber(10l);
    }
    private String calculateNumber(long radix){
        return Long.toString(20l * radix);
    }
    private String calculateNumber(){
        return Long.toString(20l);
    }
}
