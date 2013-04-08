package org.talamona.chapter10.exercise10_7_2;

import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class StackNGTest {

    public StackNGTest() {
    }

    
    @Test
    public void shouldBeLIFO(){
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        String value4 = "value4";
        
        Stack sut = new StringStack();
        
        sut.push(value1);
        sut.push(value2);
        sut.push(value3);
        sut.push(value4);
        
        String actual = sut.pop();
        assertEquals(actual, value4);

        actual = sut.pop();
        assertEquals(actual, value3);
        
        actual = sut.pop();
        assertEquals(actual, value2);
        
        actual = sut.pop();
        assertEquals(actual, value1);
        
        actual = sut.pop();
        assertNull(actual);
    }

}