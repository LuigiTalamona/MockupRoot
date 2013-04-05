package org.talamona.chapter9.example9_10;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class AnnotationsNGTest {
    
    private Integer expectedValue;    
    @Mock private Collaborator collaborator;
    @InjectMocks private SUT sut = new SUT();

    public AnnotationsNGTest() {
    }    
    @BeforeMethod
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
    @BeforeMethod
    public void setup(){
        this.expectedValue = Integer.valueOf(1234);
        Mockito.when(this.collaborator.doSomething()).thenReturn(this.expectedValue);
    }    
    @Test
    public void shouldReturnInteger(){
        System.out.println(this.getClass().getCanonicalName() + ".shouldReturnInteger");
        assertEquals(sut.useCollaborator(), this.expectedValue);
    }
}