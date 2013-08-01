package org.talamona.introduceExplainVariable.after;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/13/13
 * Time: 2:02 PM
 */
public class IntroduceExplainVariableRefactored {

    private double quantity, itemPrice;

    private final double THRESHOLD_DISCOUNT = 500d;
    private final double DISCOUNT_PERCENTAGE = 0.05d;
    private final double SHIPPING_PERCENTAGE = 0.1d;
    private final double MAX_SHIPPING = 100d;
    private final double MIN_DISCOUNT = 0d;


    public IntroduceExplainVariableRefactored(double quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice(){
        final double basePrice = this.quantity * this.itemPrice;
        final double quantityDiscount = Math.max(MIN_DISCOUNT, this.quantity - THRESHOLD_DISCOUNT) * this.itemPrice * DISCOUNT_PERCENTAGE;
        final double shipping = Math.min(basePrice * SHIPPING_PERCENTAGE, MAX_SHIPPING);

        return basePrice - quantityDiscount + shipping ;
    }

}
