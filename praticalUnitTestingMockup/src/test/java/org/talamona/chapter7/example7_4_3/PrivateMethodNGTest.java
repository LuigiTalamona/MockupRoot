package org.talamona.chapter7.example7_4_3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


import org.powermock.reflect.Whitebox; 


import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class PrivateMethodNGTest {
    
    private SomeClass instance;

    public PrivateMethodNGTest() {
    }

    @BeforeMethod
    public void setup(){
        this.instance = new SomeClass();
    }
    
    @Test
    public void testPrivateMethodUsingReflection() throws 
            NoSuchMethodException, 
            IllegalAccessException, 
            IllegalArgumentException, 
            InvocationTargetException{
        
        Class[] parameterTypes = new Class[1];
        parameterTypes[0] = java.lang.Long.class;
        
        Method m = instance.getClass().getDeclaredMethod("aMethod", parameterTypes);
        m.setAccessible(true);
        
        Object[] params = new Object[1];
        params[0] = 6968l;
        
        Boolean result = (Boolean) m.invoke(instance, params);
        
        assertTrue(result);
    }
    @Test
    public void testPrivateMethodUsingPowerMock() throws Exception{
        Boolean retValue = Whitebox.invokeMethod(instance, "aMethod", 6968l);
        assertTrue(retValue);
    }
}