/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.talamona.chapter6.example6_7;

import java.util.HashSet;
import java.util.Set;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class JVMUniqueIdGeneratorParallelTestNGTest {
    
    private IdGenerator instance;
    private Set<Long> ids;

    public JVMUniqueIdGeneratorParallelTestNGTest() {
        this.ids = new HashSet<Long>(100);
        
    }
    
    @BeforeTest
    public void prepare(){
        
    }

    @BeforeMethod
    public void setup(){
        this.instance = new AtomicIdGenerator();
    }
    
    @Test(threadPoolSize = 7, invocationCount = 100)
    public void idsShouldBeUnique(){
        
        assertTrue(ids.add(instance.nextId()));
    }
}