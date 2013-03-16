package org.talamona.chapter3.exercise3_11_3;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class HashMapPropertiesNGTest {

    private Map instance;

    public HashMapPropertiesNGTest() {
    }

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                    {"key1", Integer.valueOf(100)},
                    {"key2", Double.valueOf(100d)},
                    {null, "Luigi"}};
    }

    @BeforeMethod
    private void setup() {
        this.instance = new HashMap();

    }

    @Test(dataProvider = "getTestValues")
    public void testHashMapProperties(Object key, Object value) {
        System.out.println("testHashMapProperties");
        instance.put(key, value);
        Object expected = instance.get(key);

        assertEquals(value, expected);
        Boolean newValue = Boolean.FALSE;
        instance.put(key, newValue);

        expected = instance.get(key);
        assertEquals(newValue, expected);
    }

    @Test(dataProvider = "getTestValues")
    public void testHashMapClear(Object key, Object value) {
        System.out.println("testHashMapClear");
        instance.put(key, value);
        int size = instance.size();
        assertTrue(size > 0);
        
        instance.clear();
        size = instance.size();
        assertTrue(size == 0);
    }
}
