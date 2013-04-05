package org.talamona.chapter7.exercise7_8_1;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
@PrepareForTest(EmailServer.class)
public class EmailClientNGTest {

    public EmailClientNGTest() {
    }

    
//    @ObjectFactory
//    public IObjectFactory getObjectFactory(){
//        return new org.powermock.modules.testng.PowerMockObjectFactory();
//    }

    @BeforeMethod
    public void setup(){
        MockitoAnnotations.initMocks(this);
        // Run before every test method
    }
    
    @Test(enabled=false)
    public void testEmailSender() throws Exception{
        Email e = Mockito.mock(Email.class);
        PowerMockito.whenNew(Email.class).withAnyArguments().thenReturn(e);
        PowerMockito.mockStatic(EmailServer.class);
        
        
        
        //PowerMockito.when(EmailServer.class, "sendMail", e).thenReturn(Boolean.TRUE);
        
        //PowerMockito.verifyNew(Email.class);
        
        //PowerMockito.verifyStatic();
        //Boolean actual = EmailServer.sendMail(e);
        //assertEquals(actual, Boolean.TRUE);
        
    }

}