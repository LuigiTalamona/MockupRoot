package org.talamona.conditionals.polymorphism.before;

import org.talamona.conditionals.polymorphism.before.Manager;
import org.talamona.conditionals.polymorphism.before.Employee;
import org.talamona.conditionals.polymorphism.before.SalesMan;
import org.talamona.conditionals.polymorphism.before.Engineer;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class EmployeeTest 
{

    public EmployeeTest() {
    }

  
    @Test
    public void testPayAmount() {
        int expectedValue = 0;
        int returnValue = 0;
        
        Employee ep = new Employee(new Engineer());
        ep.setMontlySalary(new Long(1000));
        
        expectedValue = 1000;
        returnValue = ep.payAmount();
        assertTrue( expectedValue == returnValue );
        
        ep = new Employee(new SalesMan());
        ep.setMontlySalary(new Long(1000));
        ep.setCommission(Long.valueOf(500));
        
        expectedValue = 1500;
        returnValue = ep.payAmount();
        assertTrue( expectedValue == returnValue );
        
        ep = new Employee(new Manager());
        ep.setMontlySalary(new Long(2000));
        ep.setBonus(Long.valueOf(2000));
        
        expectedValue = 4000;
        returnValue = ep.payAmount();
        assertTrue( expectedValue == returnValue );
        
        
        
    }
}
