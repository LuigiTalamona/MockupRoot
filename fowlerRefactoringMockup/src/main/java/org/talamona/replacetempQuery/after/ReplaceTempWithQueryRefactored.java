package org.talamona.replacetempQuery.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/13/13
 * Time: 2:02 PM
 */
public class ReplaceTempWithQueryRefactored {

    private double quantity, itemPrice;

    private final double LOW_DISCOUNT = 0.98d;
    private final double HIGH_DISCOUNT = 0.95d;
    private final double THRESHOLD = 1000d;



    public ReplaceTempWithQueryRefactored(double quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice(){
        return basePrice() * discountFactor();
    }

    private double discountFactor() {
        return (basePrice() > THRESHOLD)? HIGH_DISCOUNT: LOW_DISCOUNT;
    }

    private double basePrice() {
        return quantity * itemPrice;
    }

}
