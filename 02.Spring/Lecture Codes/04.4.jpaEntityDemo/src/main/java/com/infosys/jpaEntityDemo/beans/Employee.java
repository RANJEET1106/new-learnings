package com.infosys.jpaEntityDemo.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "employee2")
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int empId;
    private  String empName;
    private  String empEmail;

    public Employee(String empName, String empEmail) {
        this.empName = empName;
        this.empEmail = empEmail;
    }
}
