package org.talamona.conditionals.decompose;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author luigi
 */
@Test
public class DecomposeTest {
    
    private DecomposeMockup instance; 
    private Calendar c;
    
    public DecomposeTest(){}
    
    @BeforeMethod
    public void setup(){
        instance = new DecomposeMockup(100d, 50d);
        c = new GregorianCalendar();
        c.set(Calendar.DAY_OF_MONTH, 21);
    }
    
    public void testFirstConditional(){
        System.out.println("Running testFirstConditional");
        double actual = instance.calculateAmount(new Date());
        double expected = 100d * 50d + 100d;
        assertEquals(actual, expected);
        
        c.set(Calendar.MONTH, Calendar.JULY);
        expected = 100d + (100d * 0.2);
        actual = instance.calculateAmount(c.getTime());
        assertEquals(actual, expected);
    }
    
    public void testFirstConditionalRefactored(){
        System.out.println("Running testFirstConditionalRefactored");
        double actual = instance.calculateAmountRefactored(new Date());
        double expected = 100d * 50d + 100d;
        
        assertEquals(actual, expected);
        
        c.set(Calendar.MONTH, Calendar.JULY);
        
        expected = 100d + (100d * 0.2);
        actual = instance.calculateAmount(c.getTime());
        assertEquals(actual, expected);
    }
    
    public void testSummerLimits(){
        System.out.println("Running testSummerLimits");
        Date firstLimit, lastLimit;
        
        firstLimit = DecomposeMockup.SummerLimits.SUMMER_START.getLimit();
        lastLimit = DecomposeMockup.SummerLimits.SUMMER_END.getLimit();
        
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        
        c.set(Calendar.MONTH, Calendar.JUNE);
        String actualFirstLimit = df.format(c.getTime());
        
        c.set(Calendar.MONTH, Calendar.SEPTEMBER);
        String actualLastLimit = df.format(c.getTime());
        
        assertEquals(actualFirstLimit, df.format(firstLimit));
        assertEquals(actualLastLimit, df.format(lastLimit));
    }
    
}
