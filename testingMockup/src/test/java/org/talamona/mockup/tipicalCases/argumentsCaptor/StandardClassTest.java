package org.talamona.mockup.tipicalCases.argumentsCaptor;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/7/13
 * Time: 2:43 PM
 */
public class StandardClassTest {


    @Test
    public void testDoSomethingWithClassParam() throws Exception {

        StandardClass sut = Mockito.mock(StandardClass.class);

        ParameterClass param = new ParameterClass();


        sut.doSomethingWithClassParam(param);

        ArgumentCaptor<ParameterClass> argumentCaptor = ArgumentCaptor.forClass(ParameterClass.class);

        verify(sut).doSomethingWithClassParam(argumentCaptor.capture());
        ParameterClass pc = argumentCaptor.getValue();
        if (pc != null){
            System.out.println(pc.getParameterValue());
        }else{
            assertTrue(false);
        }







    }
}
