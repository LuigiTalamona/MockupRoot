package org.talamona.mockup.tipicalCases.classStatic;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.util.reflection.Whitebox;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/8/13
 * Time: 3:12 PM
 */
@PrepareForTest({ClassWithNormalAndStaticMethods.class})
public class ClientForClassWithNormalAndStaticMethodsSpyMockAnnotationTest extends PowerMockTestCase{
    private ClientClassForClassWithNormalAndStaticMethods sut;

    @Mock private ClassWithNormalAndStaticMethods delegateMocked;
    @Spy  private ClassWithNormalAndStaticMethods delegateSpyed = new ClassWithNormalAndStaticMethods();

    @BeforeMethod
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.sut = new ClientClassForClassWithNormalAndStaticMethods();
    }
    @Test
    public void shouldBeDoSomethingSpyingClassWithNormalAndStaticMethod() throws Exception {

        Whitebox.setInternalState(this.sut, "instance", delegateSpyed);

        // IF I SPYING A CLASS (delegateSpyed, IT'S MANDATORY TO DEFINE WHAT HAPPEN WHEN METHODS ARE CALLED
        Mockito.doNothing().when(delegateSpyed).openConnection(anyInt());
        Mockito.doNothing().when(delegateSpyed).openConnection(anyInt(), anyString());
        Mockito.doNothing().when(delegateSpyed).commitTransaction();
        Mockito.doNothing().when(delegateSpyed).closeConnection();
        Mockito.doNothing().when(delegateSpyed).rollbackTransaction();

        PowerMockito.mockStatic(ClassWithNormalAndStaticMethods.class);
        PowerMockito.when(ClassWithNormalAndStaticMethods.isNotZero(anyMap())).thenReturn(true);
        assertTrue(sut.doSomething());
    }
    @Test
    public void shouldBeDoSomethingMockingClassWithNormalAndStaticMethod() throws Exception {

        Whitebox.setInternalState(this.sut, "instance", delegateMocked);

        PowerMockito.mockStatic(ClassWithNormalAndStaticMethods.class);
        PowerMockito.when(ClassWithNormalAndStaticMethods.isNotZero(anyMap())).thenReturn(true);
        assertTrue(sut.doSomething());
    }
}
