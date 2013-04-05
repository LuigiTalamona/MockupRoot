package org.talamona.chapter7.example7_5_4;

import java.util.Calendar;
import java.util.Locale;
import org.mockito.Mockito;
import org.talamona.chapter7.example7_4_3.SomeCollaborator;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class PartialSutNGTest {

    public PartialSutNGTest() {
    }

    @BeforeMethod
    public void setup(){
        // Run before every test method
    }
    
    @Test
    public void testUsingSpy(){
        Calendar c = Calendar.getInstance(Locale.ITALIAN);
        Integer expected = Integer.valueOf(c.get(Calendar.DAY_OF_YEAR));
        MyPartialSut sut = Mockito.spy(new MyPartialSut());
        SomeCollaborator mc = Mockito.mock(SomeCollaborator.class);
        Mockito.when(mc.makeCalc()).thenReturn(expected);
        
        Mockito.doReturn(mc).when(sut).createCollaborator();
        
        Integer actual = sut.invoke();
        
        Mockito.verify(mc).makeCalc();
        assertEquals(actual, expected);
    }
}