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
public class CripterTest extends TestCase {
    
    public CripterTest(String testName) {
        super(testName);
    }

    /**
     * Test of encriptString method, of class Cripter.
     */
    public void testEncriptString() {
        System.out.println("encriptString");
        String plain = "password1";
        Cripter instance = new Cripter();
        String expResult = instance.encriptString(plain);
        String result = instance.encriptString(plain);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of decriptString method, of class Cripter.
     */
    public void testDecriptString() {
        System.out.println("decriptString");
        Cripter instance = new Cripter();
        String cripted = instance.encriptString("password1");
        String expResult = "password1";
        String result = instance.decriptString(cripted);
        assertEquals(expResult, result);
    }
}
