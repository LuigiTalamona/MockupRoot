package org.talamona.chapter3.exercise3_11_4;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class FahrenheitCelsiusNGTest {


    public FahrenheitCelsiusNGTest() {
    }

    @DataProvider
    private Object[][] getFahrenheitValues() {
        return new Object[][]{
            // Fahrenheit, Celsius
                    {50d, 10d},
                    {234d, 112.22},
                    {586.99d, 308.33d},
                    {253.40d, 123d},
                    {1632.2d, 889d},
                    {2456.6d, 1347d}
        };
    }
    @DataProvider
    private Object[][] getIllegalValues() {
        return new Object[][]{
            // Fahrenheit, Celsius
                    {null, null},
                    {"pippo", 112.22}
        };
    }


    @Test(dataProvider="getFahrenheitValues")
    public void shouldConvertCelsiusToFahrenheit(Double fahrenheit, Double celsius) {
        System.out.println("shouldConvertCelsiusToFahrenheit");
        
        assertEquals(FahrenheitCelsiusConverter.toCelsius(fahrenheit), celsius);
    }
    @Test(dataProvider="getFahrenheitValues")
    public void shouldConvertFahrenheitToCelsius(Double fahrenheit, Double celsius) {
        System.out.println("shouldConvertFahrenheitToCelsius");
        
        assertEquals(FahrenheitCelsiusConverter.toFahrenheit(celsius), fahrenheit);
    }
    @Test(dataProvider="getIllegalValues", expectedExceptions = {NullPointerException.class, ClassCastException.class})
    public void shouldThrowException(Object value1, Object value2) {
        System.out.println("shouldThrowException");
        
        assertEquals(FahrenheitCelsiusConverter.toFahrenheit((Double)value1), value2);
    }
    

}
