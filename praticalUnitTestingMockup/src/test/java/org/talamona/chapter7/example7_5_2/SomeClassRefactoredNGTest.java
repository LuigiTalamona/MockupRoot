package org.talamona.chapter7.example7_5_2;

import java.util.Calendar;
import java.util.Locale;
import org.mockito.Mockito;
import org.talamona.chapter7.example7_4_3.SomeClassRefactored;
import org.talamona.chapter7.example7_4_3.SomeCollaborator;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class SomeClassRefactoredNGTest {
    
    private SomeClassRefactored instance;
    private SomeCollaborator sc;
    private Calendar cal;

    public SomeClassRefactoredNGTest() {
    }

    @BeforeMethod
    public void setup(){
        sc = Mockito.mock(SomeCollaborator.class);
        cal = Calendar.getInstance(Locale.ITALIAN);
    }
    
    @Test 
    public void testRefactoredUsingConstructor(){
        Integer expected = cal.get(Calendar.DAY_OF_YEAR);
        Mockito.when(sc.makeCalc()).thenReturn(expected);
        this.instance = new SomeClassRefactored(sc);
        Integer actual = this.instance.secondMethod();
        Mockito.verify(sc).makeCalc();
        assertEquals(actual, expected);
    }
    
    @Test 
    public void testRefactoredUsingSetter(){
        Integer expected = cal.get(Calendar.DAY_OF_YEAR);
        Mockito.when(sc.makeCalc()).thenReturn(expected);
        this.instance = new SomeClassRefactored();
        this.instance.setCollaborator(sc);
        Integer actual = this.instance.secondMethod();
        Mockito.verify(sc).makeCalc();
        assertEquals(actual, expected);
    }
}