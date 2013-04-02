package org.talamona.chapter6.example6_8;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class HelloNGTest {
    
    private Hello instance;

    public HelloNGTest() {
    }


    @BeforeMethod
    public void setup(){
        this.instance = new Hello();
    }
    
    //@Test
    public void shouldSayGoodMorningInMorning() {
        System.out.println("shouldSayGoodMorningInMorning");
        String expResult = "Good Morning";
        String result = instance.sayHello();
        assertEquals(result, expResult);
    }
    //@Test
    public void shouldSayGoodAfternoonInAfternoon() {
        System.out.println("shouldSayGoodAfternoonInAfternoon");
        String expResult = "Good Afternoon";
        String result = instance.sayHello();
        assertEquals(result, expResult);
    }

}