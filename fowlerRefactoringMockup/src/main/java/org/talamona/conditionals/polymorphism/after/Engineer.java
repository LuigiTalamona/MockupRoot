package org.talamona.conditionals.polymorphism.after;


public class Engineer extends EmployeeType {

    public Engineer() {
        super();
    }
    @Override
    public int payAmount(Employee e) {
        return e.getMontlySalary().intValue();
    }
    
    
}
