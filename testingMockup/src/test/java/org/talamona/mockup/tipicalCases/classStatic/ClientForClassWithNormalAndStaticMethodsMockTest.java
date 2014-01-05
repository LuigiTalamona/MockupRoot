package org.talamona.mockup.tipicalCases.classStatic;

import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.internal.util.reflection.Whitebox;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Matchers.*;
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
public class ClientForClassWithNormalAndStaticMethodsMockTest extends PowerMockTestCase {

    private ClientClassForClassWithNormalAndStaticMethods sut;

    @BeforeTest
    public void setup(){
        this.sut = new ClientClassForClassWithNormalAndStaticMethods();
    }
    @Test
    public void shouldBeDoSomethingMockingClassWithNormalAndStaticMethod() throws Exception {
        ClassWithNormalAndStaticMethods delegate = Mockito.mock(ClassWithNormalAndStaticMethods.class);
        Whitebox.setInternalState(this.sut, "instance", delegate);
        mockStatic(ClassWithNormalAndStaticMethods.class);
        when(ClassWithNormalAndStaticMethods.isNotZero(anyMap())).thenReturn(true);
        boolean actual = sut.doSomething();
        assertTrue(actual);
    }
    @Test
    public void shouldBeFailNotMockingStaticMethod() throws Exception {
        ClassWithNormalAndStaticMethods delegate = Mockito.mock(ClassWithNormalAndStaticMethods.class);
        Whitebox.setInternalState(this.sut, "instance", delegate);
        try{
            boolean actual = sut.doSomething();
            assertTrue(actual);
        }catch(RuntimeException e){
            System.out.println(e.getMessage() + " - Invoked real method on delegate (static method)");
        }
    }
}
