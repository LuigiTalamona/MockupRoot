package org.talamona.replacetempQuery;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/13/13
 * Time: 2:02 PM
 */
public class ReplaceTempWithQueryBase {

    private double quantity, itemPrice;

    public ReplaceTempWithQueryBase(double quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice(){
        double basePrice = quantity * itemPrice;
        double discountFactor = (basePrice > 1000)? 0.95: 0.98;
        return basePrice * discountFactor;
    }

}
