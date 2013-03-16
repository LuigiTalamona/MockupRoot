package org.talamona.chapter3.exercise3_11_4;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author luigi
 */
class FahrenheitCelsiusConverter {
    
    public static Double toFahrenheit(Double celsius){
        // ºF = ºC * 1.8000 + 32.00
        Double dv = Double.valueOf(celsius).doubleValue() * 1.8000d + 32d;
        return round(dv, 2);
    }
    
    public static Double toCelsius(Double fahrenheit){
        // ºC = (ºF - 32.00)/ 1.8000
        Double dv = (Double.valueOf(fahrenheit).doubleValue() -32.00d) / 1.8000d;
        return round(dv, 2);
    }
    
    private static double round(Double value, int scale){
        BigDecimal bd = new BigDecimal(value);
        BigDecimal scaled = bd.setScale(scale, RoundingMode.HALF_UP);
        return scaled.doubleValue();
        
    }
    /* BEFORE REFACTORING
    public static Double toFahrenheit(Double celsius){
        // ºF = ºC * 1.8000 + 32.00
        Double dv = Double.valueOf(celsius).doubleValue() * 1.8000d + 32d;
        return round(dv, 2);
        
        BigDecimal bd = new BigDecimal(dv);
        BigDecimal scaled = bd.setScale(2, RoundingMode.HALF_UP);
        return Double.valueOf(scaled.doubleValue());
    }
    
    public static Double toCelsius(Double fahrenheit){
        // ºC = (ºF - 32.00)/ 1.8000
        Double dv = (Double.valueOf(fahrenheit).doubleValue() -32.00d) / 1.8000d;
        return round(dv, 2);
        
        BigDecimal bd = new BigDecimal(dv);
        BigDecimal scaled = bd.setScale(2, RoundingMode.HALF_UP);
        return Double.valueOf(scaled.doubleValue());
    }
    */ 
    
}