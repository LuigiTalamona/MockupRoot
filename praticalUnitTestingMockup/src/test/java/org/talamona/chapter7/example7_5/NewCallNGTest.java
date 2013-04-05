package org.talamona.chapter7.example7_5;

import java.util.Calendar;
import java.util.Locale;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.talamona.chapter7.example7_4_3.SomeClass;
import org.talamona.chapter7.example7_4_3.SomeCollaborator;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author luigi
 */

@PrepareForTest(SomeClass.class)
public class NewCallNGTest {
    
    public NewCallNGTest() {
    }

//    @ObjectFactory
//    public IObjectFactory getObjectFactory(){
//        return new org.powermock.modules.testng.PowerMockObjectFactory();
//    }

    @BeforeMethod
    public void setup(){
        // Run before every test method
    }
    
    //@Test
    public void useCollaboratorsDoubleWhenAreHide() throws Exception{
        SomeClass instance = new SomeClass();
        Calendar cal = Calendar.getInstance(Locale.ITALIAN);
        Integer expected = Integer.valueOf(cal.get(Calendar.DAY_OF_YEAR));

        SomeCollaborator sc = Mockito.mock(SomeCollaborator.class);
        Mockito.when(sc.makeCalc()).thenReturn(expected);
        
        PowerMockito.whenNew(SomeCollaborator.class).withNoArguments().thenReturn(sc);
        Integer actual = instance.secondMethod();
        assertEquals(actual, expected);
    }
}