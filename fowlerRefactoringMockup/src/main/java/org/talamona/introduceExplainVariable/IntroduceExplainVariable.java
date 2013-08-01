package org.talamona.introduceExplainVariable;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/13/13
 * Time: 2:02 PM
 */
public class IntroduceExplainVariable {

    private double quantity, itemPrice;

    public IntroduceExplainVariable(double quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice(){
        // price is base price - quantity discount + shipping
        return this.quantity * this.itemPrice -
                Math.max(0, this.quantity - 500) * this.itemPrice * 0.05d +
                Math.min(this.quantity * this.itemPrice * 0.1d, 100d);
    }

}
