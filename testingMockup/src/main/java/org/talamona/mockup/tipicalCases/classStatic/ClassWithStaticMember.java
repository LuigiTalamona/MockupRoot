package org.talamona.mockup.tipicalCases.classStatic;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 7/29/13
 * Time: 3:44 PM
 */
public class ClassWithStaticMember {


    public String sampleMethod(){
        Long l = StaticClass.createNumber();
        return l.toString();
    }
}
