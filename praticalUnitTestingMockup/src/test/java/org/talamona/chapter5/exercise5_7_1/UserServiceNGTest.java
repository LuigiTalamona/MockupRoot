package org.talamona.chapter5.exercise5_7_1;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class UserServiceNGTest {

    private UserService instance;
    private UserDAO dao;
    private SecurityService ss;
    private User user;

    public UserServiceNGTest() {
    }

    @BeforeMethod
    public void setup() {
        this.instance = new UserServiceImpl();

        this.dao = Mockito.mock(UserDAO.class);
        this.ss = Mockito.mock(SecurityService.class);
        this.user = Mockito.mock(User.class);

        this.instance.setDao(this.dao);
        this.instance.setSecurityService(this.ss);

        Mockito.when(ss.md5(Mockito.anyString())).thenReturn(Mockito.anyString());
        Mockito.when(dao.updateUser(user)).thenReturn(true);
        Mockito.doNothing().when(user).setPassword(Mockito.anyString());
    }

    @Test
    public void shouldUpdatePassword() throws Exception {
        System.out.println("shouldUpdatePassword");

        instance.assignPassword(user);
        Mockito.verify(user).setPassword("");
        Mockito.verify(dao).updateUser(user);

    }

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldBeThrowException() throws Exception {
        System.out.println("shouldBeThrowException");

        Mockito.when(this.ss.md5(Mockito.anyString())).thenReturn(null);
        instance.assignPassword(user);

        Mockito.verify(user).setPassword(null);
        Mockito.verify(dao).updateUser(user);
    }
}