package org.talamona.mockup.tipicalCases.classStatic;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 7/29/13
 * Time: 3:46 PM
 */
public class StaticClass {

    public static Long createNumber(){
        Date date = new Date();
        return Long.valueOf(date.getTime());
    }
}
