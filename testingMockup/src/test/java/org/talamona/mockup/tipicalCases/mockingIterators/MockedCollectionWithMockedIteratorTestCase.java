package org.talamona.mockup.tipicalCases.mockingIterators;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/4/14
 * Time: 2:56 PM
 */
public class MockedCollectionWithMockedIteratorTestCase {
    private List myList;

    @BeforeMethod
    public void setup(){
        myList = mock(List.class);
        Iterator it = mock(Iterator.class);
        when(it.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        when(it.next()).thenReturn("First String").thenReturn("Second String").thenReturn("Third String");
        when(this.myList.iterator()).thenReturn(it);

    }
    @Test
    public void shouldBeReturnSomeItems(){
        Iterator iterator = this.myList.iterator();
        int counter = 0;
        while(iterator.hasNext()){
          if (iterator.next().toString().contains("String")){
              counter ++;
          }
        }
        assertEquals(counter, 3);
    }


}
