package org.talamona.conditionals.polymorphism.after;

/**
 *
 * @author luigi
 */
class Employee {
    private EmployeeType typeCode;
    private Long montlySalary, commission, bonus;
    
    public Employee(){
    }
    
    public Employee(EmployeeType typeCode){
        this.typeCode = typeCode;
        this.commission = Long.valueOf(0);
        this.bonus = Long.valueOf(0);
    }

    int payAmount() {
        return  this.typeCode.payAmount(this);
    }
/*
    private EmployeeType.Type getType() {
        return this.typeCode.getType();
    }
*/
    public void setMontlySalary(Long aLong) {
        this.montlySalary = aLong;
    }
    public Long getMontlySalary() {
        return this.montlySalary;
    }

    public Long getCommission() {
        return commission;
    }

    public void setCommission(Long commission) {
        this.commission = commission;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    
    
}
