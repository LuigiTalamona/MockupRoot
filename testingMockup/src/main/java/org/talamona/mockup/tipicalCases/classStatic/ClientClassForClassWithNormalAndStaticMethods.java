package org.talamona.mockup.tipicalCases.classStatic;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/8/13
 * Time: 3:07 PM
 */
public class ClientClassForClassWithNormalAndStaticMethods {
    private ClassWithNormalAndStaticMethods instance;

    public boolean doSomething(){

        Map<String, Object> params = null;

        if (instance != null){
            instance.openConnection(100);
            instance.commitTransaction();
            instance.closeConnection();
            instance.rollbackTransaction();
        }
        return instance.isNotZero(params);
    }
}
