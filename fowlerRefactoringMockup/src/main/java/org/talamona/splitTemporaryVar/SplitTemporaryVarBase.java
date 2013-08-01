package org.talamona.splitTemporaryVar;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/17/13
 * Time: 1:57 PM
 */
public class SplitTemporaryVarBase {

    private double primaryForce;
    private double mass;
    private double secondaryForce;

    public double getDistanceTravelled(int time){
        double retValue = 0d;
        int delay = 0;

        double acc = this.primaryForce / this.mass;
        int primaryTime = Math.min(time, delay);

        retValue = 0.5d * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0){
            double primaryVel = acc * delay;
            acc = (this.primaryForce + this.secondaryForce) / this.mass;
            retValue += primaryVel * secondaryTime + 0.5d * acc * secondaryTime * secondaryTime;
        }
        return retValue;
    }
}
