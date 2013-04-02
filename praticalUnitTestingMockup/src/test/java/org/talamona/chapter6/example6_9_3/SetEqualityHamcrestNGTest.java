package org.talamona.chapter6.example6_9_3;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;

/**
 *
 * @author luigi
 */
public class SetEqualityHamcrestNGTest {
    private Set<String> setA;
    private Map<String, Integer> mapA;
    private final String s1 = "Hello", s2 = "World";
    

    public SetEqualityHamcrestNGTest() {
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
        assertThat(setA, hasItem(s1));
        assertThat(setA, hasItem(s2));
        assertThat(setA, hasItems(s1,s2));
    }
    @Test
    public void mapShouldBeContainTwoElements(){
        assertThat(mapA, hasEntry(s1, 1));
        assertThat(mapA, hasEntry(s2, 2));
        assertThat(mapA, hasKey(s1));
    }
}