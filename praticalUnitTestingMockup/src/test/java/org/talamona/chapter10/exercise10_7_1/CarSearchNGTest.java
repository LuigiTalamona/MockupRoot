package org.talamona.chapter10.exercise10_7_1;

import java.awt.Color;
import java.util.List;
import org.mockito.Mockito;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author luigi
 */
public class CarSearchNGTest {

    public CarSearchNGTest() {
    }

    @BeforeMethod
    public void setup(){
        // Run before every test method
    }
    

    @Test
    public void shouldReturnsSportCars() {
        System.out.println("findSportCars");

        Engine sportEngine = Mockito.mock(Engine.class);
        Engine secondSportEngine = Mockito.mock(Engine.class);
        
        Engine standardEngine = Mockito.mock(Engine.class);
        Engine secondStandardEngine = Mockito.mock(Engine.class);
        
        Mockito.when(sportEngine.getNumberOfCylinder()).thenReturn(12);
        Mockito.when(secondSportEngine.getNumberOfCylinder()).thenReturn(8);
        
        Mockito.when(standardEngine.getNumberOfCylinder()).thenReturn(4);
        Mockito.when(secondStandardEngine.getNumberOfCylinder()).thenReturn(3);
        
        
        Manufacturer ferrari = Mockito.mock(Manufacturer.class);
        Manufacturer lamborghini = Mockito.mock(Manufacturer.class);
        Manufacturer maserati = Mockito.mock(Manufacturer.class);
        
        Manufacturer fiat = Mockito.mock(Manufacturer.class);
        Manufacturer opel = Mockito.mock(Manufacturer.class);
        
        Mockito.when(ferrari.getName()).thenReturn("Ferrari");
        Mockito.when(lamborghini.getName()).thenReturn("Lamborghini");
        Mockito.when(maserati.getName()).thenReturn("Maserati");

        Mockito.when(fiat.getName()).thenReturn("Fiat");
        Mockito.when(opel.getName()).thenReturn("Opel");
        
        
        
        Car sportCar1 = Mockito.mock(Car.class);
        Car sportCar2 = Mockito.mock(Car.class);
        Car sportCar3 = Mockito.mock(Car.class);
        
        Car standardCar1 = Mockito.mock(Car.class);
        Car standardCar2 = Mockito.mock(Car.class);
        
        Mockito.when(sportCar1.getColor()).thenReturn(Color.RED);
        Mockito.when(sportCar1.getEngine()).thenReturn(sportEngine);
        Mockito.when(sportCar1.getManufacturer()).thenReturn(ferrari);
        
        Mockito.when(sportCar2.getColor()).thenReturn(Color.ORANGE);
        Mockito.when(sportCar2.getEngine()).thenReturn(sportEngine);
        Mockito.when(sportCar2.getManufacturer()).thenReturn(lamborghini);
        
        Mockito.when(sportCar3.getColor()).thenReturn(Color.BLUE);
        Mockito.when(sportCar3.getEngine()).thenReturn(secondSportEngine);
        Mockito.when(sportCar3.getManufacturer()).thenReturn(maserati);
        
        Mockito.when(standardCar1.getColor()).thenReturn(Color.WHITE);
        Mockito.when(standardCar1.getEngine()).thenReturn(standardEngine);
        Mockito.when(standardCar1.getManufacturer()).thenReturn(fiat);
        
        Mockito.when(standardCar2.getColor()).thenReturn(Color.GRAY);
        Mockito.when(standardCar2.getEngine()).thenReturn(secondStandardEngine);
        Mockito.when(standardCar2.getManufacturer()).thenReturn(opel);
        
        
        
        
        
        CarSearch sut = new CarSearch();
        sut.addCar(sportCar1);
        sut.addCar(sportCar2);
        sut.addCar(sportCar3);
        
        sut.addCar(standardCar1);
        sut.addCar(standardCar2);
        
        List result = sut.findSportCars();
        assertTrue(result.size() == 1);
    }

}