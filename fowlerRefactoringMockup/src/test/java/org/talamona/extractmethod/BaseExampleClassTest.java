package org.talamona.extractmethod;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/6/13
 * Time: 11:39 AM
 */
public class BaseExampleClassTest {
    private Collection testElements;

    private double expected;


    @BeforeMethod
    public void setUp() throws Exception {
        double value1 = 10.0;
        double value2 = 12.0;
        double value3 = 14.0;

        this.expected = value1 + value2 + value3;

        Order o1 = Mockito.mock(Order.class);
        Order o2 = Mockito.mock(Order.class);
        Order o3 = Mockito.mock(Order.class);

        Mockito.when(o1.getAmount()).thenReturn(value1);
        Mockito.when(o2.getAmount()).thenReturn(value2);
        Mockito.when(o3.getAmount()).thenReturn(value3);

        this.testElements = new ArrayList();

        this.testElements.add(o1);
        this.testElements.add(o2);
        this.testElements.add(o3);
    }

    @Test
    public void shouldInvokePrintOwingOnBaseExampleClass() throws Exception {
        BaseExampleClass sut = new BaseExampleClass(this.testElements);
        this.invokeSut(sut);
    }
    @Test
    public void shouldInvokePrintOwingOnRefactoredExampleClass() throws Exception {
        RefactoredExampleClass sut = new RefactoredExampleClass(this.testElements);
        this.invokeSut(sut);
    }
    private void invokeSut(BaseExample sut){
        double actual = sut.printOwing();
        assertEquals(actual, this.expected);
    }

    @Test
    public void shouldInvokePrintOwingOverLoadedOnRefactoredExampleClass() throws Exception {
        RefactoredExampleClass sut = new RefactoredExampleClass(this.testElements);
        double actual = sut.printOwing(1.5);
        double expected = this.expected + 1.5;
        assertEquals(actual, expected);
    }


    
}
