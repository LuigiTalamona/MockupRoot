package org.talamona.conditionals.polymorphism.after;


/**
 *
 * @author luigi
 */
class SalesMan extends EmployeeType {

    public SalesMan() {
        super();
    }
    public int payAmount(Employee e) {
        return e.getMontlySalary().intValue() + e.getCommission().intValue();
    }
    
    
}
