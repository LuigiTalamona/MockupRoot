package org.talamona.chapter10.exercise10_7_1;

import java.util.List;
import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class CarSearchRefactoredNGTest {

    public CarSearchRefactoredNGTest() {
    }

    @BeforeMethod
    public void setup(){
        // Run before every test method
    }
    

    @Test
    public void shouldReturnsSportCars() {
        System.out.println("findSportCars");
        
        CarRefactored sportCar1 = Mockito.mock(CarRefactored.class);
        CarRefactored sportCar2 = Mockito.mock(CarRefactored.class);
        CarRefactored sportCar3 = Mockito.mock(CarRefactored.class);
        
        CarRefactored standardCar1 = Mockito.mock(CarRefactored.class);
        CarRefactored standardCar2 = Mockito.mock(CarRefactored.class);
        
        Mockito.when(sportCar1.isASportCar()).thenReturn(Boolean.TRUE);
        Mockito.when(sportCar2.isASportCar()).thenReturn(Boolean.FALSE);
        Mockito.when(sportCar3.isASportCar()).thenReturn(Boolean.TRUE);
        
        Mockito.when(standardCar1.isASportCar()).thenReturn(Boolean.FALSE);
        Mockito.when(standardCar2.isASportCar()).thenReturn(Boolean.FALSE);
        
        CarSearchRefactored sut = new CarSearchRefactored();
        sut.addCar(sportCar1);
        sut.addCar(sportCar2);
        sut.addCar(sportCar3);
        
        sut.addCar(standardCar1);
        sut.addCar(standardCar2);
        
        List result = sut.findSportCars();
        assertTrue(result.size() == 2);
    }
}