package org.talamona.mockup.tipicalCases.classStatic;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/8/13
 * Time: 3:02 PM
 */
public class ClassWithNormalAndStaticMethods {

    public void openConnection(Integer i){
        throw new RuntimeException("openConnection TBI");

    }
    public void openConnection(Integer i, String s){
        throw new RuntimeException("openConnection TBI");

    }
    public void closeConnection(){
        throw new RuntimeException("closeConnection TBI");

    }
    public void commitTransaction(){
        throw new RuntimeException("commitTransaction TBI");

    }
    public void rollbackTransaction(){
        throw new RuntimeException("rollbackTransaction TBI");

    }

    public static boolean isNotZero(Map<String, Object> params){
        throw new RuntimeException("isNotZero TBI");
    }



}
