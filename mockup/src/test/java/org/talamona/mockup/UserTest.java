/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup;

import org.talamona.mockup.Cripter;
import junit.framework.TestCase;

/**
 *
 * @author luigi
 */
public class UserTest extends TestCase {
    
    public UserTest(String testName) {
        super(testName);
    }

    /**
     * Test of getId method, of class User.
     */
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        instance.setId("myid");
        
        String expResult = "myid";
        String result = instance.getId();
        assertEquals(expResult, result);
    }


    /**
     * Test of getARSSid method, of class User.
     */
    public void testGetARSSid() {
        System.out.println("getARSSid");
        
        User instance = new User();
        instance.setARSSid("myid");
        String expResult = "myid";
        String result = instance.getARSSid();
        assertEquals(expResult, result);
    }


    /**
     * Test of getARSSpwd method, of class User.
     */
    public void testGetARSSpwd() {
        System.out.println("getARSSpwd");
        User instance = new User();
        Cripter c = new Cripter();
        
        String expResult = c.encriptString("myid");
        instance.setARSSpwd(expResult);
        String result = instance.getARSSpwd();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClearARSSpwd method, of class User.
     */
    public void testGetClearARSSpwd() {
        System.out.println("getClearARSSpwd");
        User instance = new User();
        String expResult = "mypassword";
        Cripter c = new Cripter();
        instance.setARSSpwd(c.encriptString(expResult));
        String result = instance.getClearARSSpwd();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class User.
     */
    public void testCompareTo() {
        System.out.println("compareTo");
        User instance1 = new User();
        instance1.setId("myid");
        
        User instance2 = new User();
        instance2.setId("myid");
        
        
        int expResult = 0;
        int result = instance1.compareTo((Object)instance2);
        assertEquals(expResult, result);
    }
}
