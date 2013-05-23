package org.talamona.noduplication.templatepattern;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/21/13
 * Time: 11:58 AM
 */
public abstract class VacationPolicyTemplate {

    public void calculateVacation(){
        this.calculateBaseVacationByWorkedHours();
        this.alterToAdaptToLegalMinimum();
        this.applyToPayroll();
    }
    protected abstract void alterToAdaptToLegalMinimum();

    private void calculateBaseVacationByWorkedHours() {
        // code to calculate vacations based on worked hours
        // ...
        // ...
    }
    private void applyToPayroll() {
        // code to apply vacation to payroll record
        // ...
        // ...
    }
}
