package org.talamona.mockup.tipicalCases.classStatic;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/8/13
 * Time: 3:12 PM
 */

@PrepareForTest({ClassWithNormalAndStaticMethods.class})
public class ClientForClassWithNormalAndStaticMethodsSpyTest extends PowerMockTestCase {

    @Test
    public void shouldBeDoSomethingMockingClassWithNormalAndStaticMethod() throws Exception {
        ClientClassForClassWithNormalAndStaticMethods sut = new ClientClassForClassWithNormalAndStaticMethods();

        // IF I SPYING A CLASS, IT'S MANDATORY TO DEFINE WHAT HAPPEN WHEN METHODS ARE CALLED
        ClassWithNormalAndStaticMethods delegateSpyed = spy(new ClassWithNormalAndStaticMethods());

        Whitebox.setInternalState(sut, "instance", delegateSpyed);
        doNothing().when(delegateSpyed).openConnection(anyInt());
        doNothing().when(delegateSpyed).openConnection(anyInt(), anyString());
        doNothing().when(delegateSpyed).commitTransaction();
        doNothing().when(delegateSpyed).closeConnection();
        doNothing().when(delegateSpyed).rollbackTransaction();

        mockStatic(ClassWithNormalAndStaticMethods.class);
        when(ClassWithNormalAndStaticMethods.isNotZero(anyMap())).thenReturn(true);
        assertTrue(sut.doSomething());
    }
}
