package org.talamona.chapter6.example6_7;

import java.util.HashSet;
import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class IdGeneratorNGTest {
    
    private IdGenerator instance;

    public IdGeneratorNGTest() {
    }

    @BeforeMethod
    public void setup(){
        this.instance = new AtomicIdGenerator();
    }
    
    //@Test(dataProvider="getTestValues", expectedExceptions = NullPointerException.class) 
    @Test 
    public void shouldBeReturnDifferentValues(){
        
        Long val1 = instance.nextId();
        Long val2 = instance.nextId();
        
        assertNotEquals(val1, val2);

    }
}