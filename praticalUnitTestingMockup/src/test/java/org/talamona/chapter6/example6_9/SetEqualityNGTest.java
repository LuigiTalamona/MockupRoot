package org.talamona.chapter6.example6_9;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class SetEqualityNGTest {

    public SetEqualityNGTest() {
    }


    @BeforeMethod
    public void setup(){
    }
    
    @Test
    public void twoSetAreEqualsIfTheyHaveSameContent(){
        Set<String> setA = new LinkedHashSet<String>();
        Set<String> setB = new LinkedHashSet<String>();
        
        String s1 = "Hello";
        String s2 = "World";
        
        setA.add(s1);
        setA.add(s2);
        
        setB.add(s2);
        setB.add(s1);
        
        assertEquals(setA, setB);
        
    }


}