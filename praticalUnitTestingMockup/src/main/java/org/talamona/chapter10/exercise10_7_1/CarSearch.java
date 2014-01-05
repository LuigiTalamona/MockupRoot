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
            if (verifyThisCarIsASportCar(car)){
                retValue.add(car);
            }
        }
        return retValue;
    }

    private boolean verifyThisCarIsASportCar(Car car) {
        return carHasMoreThanSixCilinders(car) &&
                        carIsRed(car) && carIsAFerrari(car);
    }

    private boolean carIsAFerrari(Car car) {
        return car.getManufacturer().getName().equals("Ferrari");
    }

    private boolean carIsRed(Car car) {
        return car.getColor().equals(Color.RED);
    }

    private boolean carHasMoreThanSixCilinders(Car car) {
        return car.getEngine().getNumberOfCylinder() > 6;
    }

}
