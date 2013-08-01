package org.talamona.chapter7.exercise7_8_1;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.IObjectFactory;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 *
 * @author luigi
 */
//@PrepareForTest(EmailServer.class)
public class EmailClientNGTest {

    public EmailClientNGTest() {
    }

    
    @ObjectFactory
    public IObjectFactory getObjectFactory(){
        return new org.powermock.modules.testng.PowerMockObjectFactory();

    }

    @BeforeMethod
    public void setup(){
        MockitoAnnotations.initMocks(this);
        // Run before every test method
    }
    
    @Test(enabled=true)
    public void testEmailSender() throws Exception{
        Email e = PowerMockito.mock(Email.class);
        PowerMockito.whenNew(Email.class).withAnyArguments().thenReturn(e);
        PowerMockito.mockStatic(EmailServer.class);

        PowerMockito.when(EmailServer.sendMail(e)).thenReturn(Boolean.FALSE);

        //PowerMockito.doReturn(Boolean.FALSE).when(EmailServer.class, "sendMail", e);

        Boolean actual = EmailServer.sendMail(e);
        assertEquals(actual, Boolean.TRUE);


        //PowerMockito.verifyNew(Email.class);

        /*


        */
        
    }

}