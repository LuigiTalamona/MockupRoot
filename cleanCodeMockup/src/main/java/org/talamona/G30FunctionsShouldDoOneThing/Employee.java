package org.talamona.G30FunctionsShouldDoOneThing;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/3/13
 * Time: 3:29 PM
 */
public interface Employee {

    public boolean isPayDay();
    public int calculatePay();
    public void deliverPay(int pay);
}
