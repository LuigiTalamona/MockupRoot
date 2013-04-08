package org.talamona.chapter10.exercise10_7_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class CarSearchRefactored {
    private List<CarRefactored> cars; 
    
    public CarSearchRefactored(){
        this.cars = new ArrayList<CarRefactored>();
    }
    
    public void addCar(CarRefactored car){
        this.cars.add(car);
    }
    
    public List<CarRefactored> findSportCars(){
        List<CarRefactored> retValue = new ArrayList<CarRefactored>();
        for (CarRefactored car: this.cars){
            if (car.isASportCar()){
                retValue.add(car);
            }
        }
        return retValue;
    }
}
