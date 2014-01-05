package org.talamona.mockup.tipicalCases.mockingIterators;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/4/14
 * Time: 2:56 PM
 */
public class SpyedCollectionWithMockedIteratorTestCase {
    private List myList;

    @BeforeMethod
    public void setup(){
        // Spying a real object, created before
        myList = spy(new ArrayList());
        Iterator it = mock(Iterator.class);
        when(it.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        when(it.next()).thenReturn("First String").thenReturn("Second String").thenReturn("Third String");
        when(this.myList.iterator()).thenReturn(it);
    }
    @Test
    public void shouldBeReturnSomeItems(){
        // The following statement returns a Mock of an Iterator
        Iterator iterator = this.myList.iterator();
        int counter = 0;
        while(iterator.hasNext()){
          if (iterator.next().toString().contains("String")){
              counter ++;
          }
        }
        assertEquals(counter, 3);
        // The following assert is true because mylist is real AND empty
        when(myList.size()).thenCallRealMethod();
        assertEquals(myList.size(), 0);
    }


}
