/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter3.exercise3_11_1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
@Test
public class ExerciseClassNGTest {
    
    public ExerciseClassNGTest() {
    }

    @Test
    public void testDoHelloWorld() {
        System.out.println("doHelloWorld");
        ExerciseClass instance = new ExerciseClass("Luigi Talamona");
        String expResult = "Hello World by Luigi Talamona";
        String result = instance.doHelloWorld();
        assertEquals(result, expResult);
    }
}
