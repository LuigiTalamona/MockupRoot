package org.talamona.mockup.tipicalCases.classStatic;

import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Matchers.*;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/8/13
 * Time: 3:12 PM
 */

@PrepareForTest({ClassWithNormalAndStaticMethods.class})
public class ClientForClassWithNormalAndStaticMethodsMockTest extends PowerMockTestCase {



    @BeforeTest
    public void init(){
        //MockitoAnnotations.initMocks(this);

    }



    @Test
    public void shouldBeDoSomethingMockingClassWithNormalAndStaticMethod() throws Exception {

        ClientClassForClassWithNormalAndStaticMethods sut = new ClientClassForClassWithNormalAndStaticMethods();
        ClassWithNormalAndStaticMethods delegate = Mockito.mock(ClassWithNormalAndStaticMethods.class);
        Whitebox.setInternalState(sut, "instance", delegate);

        /* THESE DEFINITIONS AREN'T NECESSARY
        Mockito.doNothing().when(delegate).openConnection(anyInt());
        Mockito.doNothing().when(delegate).openConnection(anyInt(), anyString());
        Mockito.doNothing().when(delegate).commitTransaction();
        Mockito.doNothing().when(delegate).closeConnection();
        Mockito.doNothing().when(delegate).rollbackTransaction();
        */

        PowerMockito.mockStatic(ClassWithNormalAndStaticMethods.class);
        PowerMockito.when(ClassWithNormalAndStaticMethods.isNotZero(anyMap())).thenReturn(true);

        boolean actual = sut.doSomething();

        assertTrue(actual);



    }
}
