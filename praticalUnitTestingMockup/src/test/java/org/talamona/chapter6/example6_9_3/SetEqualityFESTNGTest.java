package org.talamona.chapter6.example6_9_3;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;


/**
 *
 * @author luigi
 */
public class SetEqualityFESTNGTest {
    private Set<String> setA;
    private Map<String, Integer> mapA;
    private final String s1 = "Hello", s2 = "World";
    

    public SetEqualityFESTNGTest() {
    }


    @BeforeMethod
    public void setup(){
        setA = new LinkedHashSet<String>();
        mapA = new LinkedHashMap<String, Integer>();

        setA.add(s1);
        setA.add(s2);
        
        mapA.put(s1, Integer.valueOf(1));
        mapA.put(s2, Integer.valueOf(2));
    }
    
    @Test
    public void setShouldContainTwoDifferentElements(){
        assertThat(setA).isNotEmpty().hasSize(2).doesNotHaveDuplicates();
        assertThat(setA).containsOnly(s1, s2);
    }
    @Test
    public void mapShouldBeContainTwoElements(){ 
        assertThat(mapA).isNotNull().isNotEmpty().hasSize(2);
        assertThat(mapA).includes(entry(s1,1), entry(s2, 2)).excludes(entry("mio", 3));
    }
}