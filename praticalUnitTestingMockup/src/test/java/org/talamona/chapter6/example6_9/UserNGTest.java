package org.talamona.chapter6.example6_9;

import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class UserNGTest {

    public UserNGTest() {
    }


    @BeforeMethod
    public void setup(){
    }
    
    @Test
    public void ShouldReturnUsersPhone(){
        User user = new User();
        user.addPhone("0332424242");
        List<String> phones = user.getPhones();
        assertNotNull(phones);
        assertEquals(phones.size(), 1);
        assertTrue(phones.contains("0332424242"));
    }


}