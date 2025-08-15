package com.infosys.capstone.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @NotBlank(message = "Department name can't be blank")
    public String name;

    public Department(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
