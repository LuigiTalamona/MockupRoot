package org.talamona.conditionals.polymorphism.after;


class Engineer extends EmployeeType {

    public Engineer() {
        super();
    }
    @Override
    public int payAmount(Employee e) {
        return e.getMontlySalary().intValue();
    }
    
    
}
