package org.talamona.conditionals.polymorphism.before;

/**
 *
 * @author luigi
 */
class Employee {
    private EmployeeType typeCode;
    private Long montlySalary, commission, bonus;
    public Employee(){}
    
    public Employee(EmployeeType typeCode){
        this.typeCode = typeCode;
        this.commission = Long.valueOf(0);
        this.bonus = Long.valueOf(0);
        
    }

    int payAmount() {
        int retValue = 0;
        
        switch(this.getType()){
            case (EmployeeType.ENGINEER):{
                retValue = this.montlySalary.intValue();
                break;
            }
            case (EmployeeType.SALESMAN):{
                retValue = this.montlySalary.intValue() + this.commission.intValue();
                break;
            }
            case (EmployeeType.MANAGER):{
                retValue = this.montlySalary.intValue() + this.bonus.intValue();
                break;
            }
            
        }
        return retValue;
    }

    private int getType() {
        return this.typeCode.getType();
    }

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
