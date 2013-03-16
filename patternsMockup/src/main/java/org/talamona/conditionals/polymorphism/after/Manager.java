package org.talamona.conditionals.polymorphism.after;

/**
 *
 * @author luigi
 */
class Manager extends EmployeeType {

    public Manager() {
        super();
    }
    public int payAmount(Employee e) {
        return e.getMontlySalary().intValue() + e.getBonus().intValue();
    }
    
    
}
