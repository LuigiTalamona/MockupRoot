/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter5.exercise5_7_2;

import org.mockito.Mockito;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class RaceResultServiceTest {

    private RaceResultService instance;
    private Client clientA, clientB;
    private Message message;
    private MessageLogger logger;

    public RaceResultServiceTest() {
    }

    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                    {"", ""},
                    {"", ""}
                };
    }

    @BeforeMethod
    public void setup() {
        instance = new RaceResultService();
        clientA = Mockito.mock(Client.class);
        clientB = Mockito.mock(Client.class);
        message = Mockito.mock(Message.class);
        logger = Mockito.mock(MessageLogger.class);
        
        Mockito.when(clientA.getCategory()).thenReturn(Mockito.any(Category.class));
        //Mockito.when(clientB.getCategory()).thenReturn(Mockito.any(Category.class));
        //Mockito.when(message.getCategory()).thenReturn(Mockito.any(Category.class));

        //Mockito.when(logger.logMessage(Mockito.anyString(), Mockito.any(Date.class))).thenReturn(true);
    }
    //@Test(dataProvider="getTestValues", expectedExceptions = NullPointerException.class) 

    //@Test
    public void notSubscribedClientsShouldNotReceiveMessage(/*Object val1, Object val2*/) {
        System.out.println("notSubscribedClientsShouldNotReceiveMessage");

        instance.send(message);
        Mockito.verify(clientA, Mockito.never()).receive(message);
        Mockito.verify(clientB, Mockito.never()).receive(message);
    }

    //@Test
    public void subscribedClientShouldReceiveMessage(/*Object val1, Object val2*/) {
        System.out.println("subscribedClientShouldReceiveMessage");
        instance.addSubscriber(clientA);
        instance.send(message);

        Mockito.verify(clientA).receive(message);
    }
    //@Test
    public void subscribedClientForACategoryShouldReceiveMessagesOnlyForCategory() {
        System.out.println("subscribedClientForACategoryShouldReceiveMessagesOnlyForCategory");
        Category myCategory = Mockito.mock(Category.class);
        
        Mockito.doNothing().when(clientA).setCategory(Mockito.any(Category.class));
        Mockito.doNothing().when(message).setCategory(Mockito.any(Category.class));
        
        
        clientA.setCategory(myCategory);
        message.setCategory(myCategory);
        
        
        
        
        
        instance.addSubscriber(clientA);
        instance.send(message);

        Mockito.verify(clientA).getCategory();
        Mockito.verify(message).getCategory();
        
        Mockito.verify(clientA).receive(message);
    }

    //@Test(dataProvider="getTestValues", expectedExceptions = NullPointerException.class) 
    //@Test
    public void multipleClientsShouldReceiveMessage(/*Object val1, Object val2*/) {
        System.out.println("multipleClientsShouldReceiveMessage");

        instance.addSubscriber(clientA);
        instance.addSubscriber(clientB);

        instance.send(message);
        Mockito.verify(clientA).receive(message);
        Mockito.verify(clientB).receive(message);
    }

    //@Test(dataProvider="getTestValues", expectedExceptions = NullPointerException.class) 
    //@Test
    public void shouldPermitsOneSubscriptionForClient(/*Object val1, Object val2*/) {
        System.out.println("shouldPermitsOneSubscriptionForClient");

        instance.addSubscriber(clientA);
        instance.addSubscriber(clientA);

        instance.send(message);
        Mockito.verify(clientA).receive(message);
    }

    //@Test(dataProvider="getTestValues", expectedExceptions = NullPointerException.class) 
    //@Test
    public void unsubscribedClientShouldNotReceiveMessage(/*Object val1, Object val2*/) throws UnsubscribedClientException {
        System.out.println("unsubscribedClientShouldNotReceiveMessage");

        instance.addSubscriber(clientA);
        instance.removeSubscriber(clientA);
        instance.send(message);

        Mockito.verify(clientA, Mockito.never()).receive(message);

    }

    //@Test(expectedExceptions = UnsubscribedClientException.class)
    public void unsubscribedClientUnsubscribeShouldThrowException(/*Object val1, Object val2*/) throws UnsubscribedClientException {
        System.out.println("unsubscribedClientUnsubscribeShouldThrowException");

        instance.removeSubscriber(clientA);

    }

    //@Test
    public void sentMessageShoulbeBeLogged(/*Object val1, Object val2*/) {
        System.out.println("sentMessageShoulbeBeLogged");

        instance.addSubscriber(clientA);
        instance.send(message, logger);
        Mockito.verify(logger).logMessage(message.getText(), message.getDate());


    }
    //@Test
    public void messageShouldHaveCategory(/*Object val1, Object val2*/) {
        System.out.println("messageShouldHaveCategory");
        
        Category category = Mockito.mock(Category.class);
        
        
        message.setCategory(category);
        Mockito.when(message.getCategory()).thenReturn(category);
        Category newCategory = message.getCategory();
        

        Mockito.verify(message).getCategory();
        
        assertEquals(category, newCategory);


    }
}