package org.talamona.mockup.tipicalCases.verifyingBehavior;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 3:22 PM
 */
public class WaterSource {
    private double pressure;
    private double temperature;

    public WaterSource(){
        this.pressure = 1.0d;
        this.temperature = 18.0d;
    }
    public WaterSource(double pressure, double temperature){
        this.pressure = pressure;
        this.temperature = temperature;
    }

    public boolean doSelfCheck(){
        return (this.temperature == 18.0d) && (this.pressure == 1.0d);
    }

    public double calculateCapacity(){
        return 100d;
    }


    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
