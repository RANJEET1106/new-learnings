package com.infosys.employee.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer employeeId;

    private @Getter @Setter String employeeName;
    private @Getter @Setter String employeeRole;
    private @Getter @Setter String employeeDepartment;
    private @Getter @Setter Integer employeeSalary;
    private @Getter @Setter String employeeLocation;

    public Employee( String employeeName, String employeeRole, String employeeDepartment, Integer employeeSalary, String employeeLocation) {
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
        this.employeeLocation = employeeLocation;
    }

    @Override
    public String toString() {
        return "Employees{"+"employeeID"+employeeId+
                ", employeeName="+employeeName+'\''+
                ", employeeRole=" + employeeRole +'\''+
                ",employeeDepartment=" + employeeDepartment +'\''+
                ", employeeSalary=" + employeeSalary +'\''+
                ", employeeLocation= "+employeeLocation+'\''+'}';
    }


}
