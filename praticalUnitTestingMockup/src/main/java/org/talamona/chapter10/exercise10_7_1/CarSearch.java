package org.talamona.chapter10.exercise10_7_1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class CarSearch {
    private List<Car> cars; 
    
    public CarSearch(){
        this.cars = new ArrayList<Car>();
    }
    public void addCar(Car car){
        this.cars.add(car);
    }
    public List<Car> findSportCars(){
        List<Car> retValue = new ArrayList<Car>();
        for (Car car: this.cars){
            boolean result = car.getEngine().getNumberOfCylinder() > 6;
            result &= car.getColor().equals(Color.RED);
            result &= car.getManufacturer().getName().equals("Ferrari");
            if (result){
                retValue.add(car);
            }
        }
        return retValue;
    }
    
}
