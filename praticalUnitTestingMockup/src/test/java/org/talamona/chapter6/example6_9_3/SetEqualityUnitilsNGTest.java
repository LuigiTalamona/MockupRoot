package org.talamona.chapter6.example6_9_3;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.unitils.reflectionassert.ReflectionComparatorMode;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
/**
 *
 * @author luigi
 */
public class SetEqualityUnitilsNGTest {
    private Set<String> setA, setB;
    private final String s1 = "Hello", s2 = "World";
    

    public SetEqualityUnitilsNGTest() {
    }


    @BeforeMethod
    public void setup(){
        setA = new LinkedHashSet<String>();
        setB = new LinkedHashSet<String>();
        

        setA.add(s1);
        setA.add(s2);
        
        setB.add(s2);
        setB.add(s1);
    }
    
    @Test
    public void twoSetAreEqualsIfTheyHaveSameContentAndSameOrder(){
        // Resemble order to pass test
        setB.clear();
        setB.add(s1);
        setB.add(s2);
        assertReflectionEquals(setA, setB);
        
    }
    @Test
    public void twoSetAreEqualsIfTheyHaveSameContentAndAnyOrder(){
        assertReflectionEquals(setA, setB, ReflectionComparatorMode.LENIENT_ORDER);
        
    }


}