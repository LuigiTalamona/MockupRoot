package org.talamona.G30FunctionsShouldDoOneThing;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/3/13
 * Time: 3:34 PM
 */
public class PaymentsManager {
    private Employee[] employees;

    // This function makes three different things
    /*
    public void pay(){
        for (Employee e: this.employees){
            if (e.isPayDay()){
                int pay = e.calculatePay();
                e.deliverPay(pay);
            }
        }
    }*/
    // It's better divide it in the following:
    public void pay(){
        for (Employee e: this.employees){
            this.payIfNecessary(e);
        }

    }

    private void payIfNecessary(Employee e) {
        if (e.isPayDay()){
            this.calculateAndDeliver(e);
        }
    }

    private void calculateAndDeliver(Employee e) {
        int payment = e.calculatePay();
        e.deliverPay(payment);
    }
}
