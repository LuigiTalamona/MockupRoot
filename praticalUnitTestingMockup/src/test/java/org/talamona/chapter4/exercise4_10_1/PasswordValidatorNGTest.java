package org.talamona.chapter4.exercise4_10_1;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;


/**
 *
 * @author luigi
 */
public class PasswordValidatorNGTest {
    
    private PasswordValidator instance;
    private final int PWD_LENGHT = 10;

    public PasswordValidatorNGTest() {
    }
    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
            {"123456_7890", Boolean.TRUE}, 
            {"aaaaabb", Boolean.FALSE}, 
            {"1bbbbbb_ccccc", Boolean.TRUE}
        };
    }
    @BeforeMethod
    public void setup(){
        this.instance = new PasswordValidator(PWD_LENGHT);
    }
    @Test(dataProvider="getTestValues")
    public void ShouldBeValidatePwd(Object pwd, Object result){
        System.out.println("ShouldBeValidatePwd test");
        assertEquals(instance.validatePassword((String)pwd), result);
    }
    @Test
    public void ShouldBeSetPwdLenght(){
        System.out.println("ShouldBeSetPwdLenght test");
        assertEquals(PWD_LENGHT, instance.getPwdLenght());
    }
    @Test(dataProvider="getTestValues")
    public void ShouldBeMoreThanNChars(Object pwd, Object result){
        System.out.println("ShouldBeMoreThanNChars test");
        assertEquals(instance.checkPasswordLenght((String)pwd), result);
    }
    @Test(dataProvider="getTestValues")
    public void ShouldContainsOneMoreDigits(Object pwd, Object result){
        System.out.println("ShouldContainsOneMoreDigits test");
        assertEquals(instance.isContainingDigits((String)pwd), result);
    }
    @Test(dataProvider="getTestValues")
    public void ShouldBeContainsUnderscore(Object pwd, Object result){
        System.out.println("ShouldBeContainsUnderscore test");
        assertEquals(instance.isContainingUnderscore((String)pwd), result);
    }
    /* (dataProvider="getTestValues", expectedExceptions = NullPointerException.class)*/ 
}