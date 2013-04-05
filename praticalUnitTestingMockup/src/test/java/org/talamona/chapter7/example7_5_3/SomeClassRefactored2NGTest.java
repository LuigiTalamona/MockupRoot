package org.talamona.chapter7.example7_5_3;

import java.util.Calendar;
import java.util.Locale;
import org.mockito.Mockito;
import org.talamona.chapter7.example7_4_3.SomeClassRefactored2;
import org.talamona.chapter7.example7_4_3.SomeCollaborator;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class SomeClassRefactored2NGTest {
    
    private SomeCollaborator sc;
    private Calendar cal;
    
    
    private class SubClassInstance extends SomeClassRefactored2{
        
        @Override
        protected SomeCollaborator createCollaborator(){
            return sc;
        }
    }
    

    public SomeClassRefactored2NGTest() {
    }

    @BeforeMethod
    public void setup(){
        sc = Mockito.mock(SomeCollaborator.class);
        cal = Calendar.getInstance(Locale.ITALIAN);
    }
    
    @Test 
    public void testRefactoredUsingSubClass(){
        Integer expected = cal.get(Calendar.DAY_OF_YEAR);
        Mockito.when(sc.makeCalc()).thenReturn(expected);
        SubClassInstance instance = new SubClassInstance();
        Integer actual = instance.secondMethod();
        Mockito.verify(sc).makeCalc();
        assertEquals(actual, expected);
    }
}