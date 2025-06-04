package com.infosys.demodata.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_emp")
public class Employee {

    public Employee() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int emp_id;

    @Column
    private @Getter @Setter String emp_name;
    @Column(name= "emp_dept")
    private @Getter @Setter  String dept_name;

    public Employee(String emp_name, String dept_name) {
        this.emp_name = emp_name;
        this.dept_name = dept_name;
    }


}
