package com.infosys.capstone.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Employee name can't be blank")
    private String name;
    @DecimalMin("0.0")
    private Double salary;
    @Min(1) @Max(10)
    private Integer rating;
    @ManyToOne(fetch = FetchType.EAGER)
    Department department;

    @ManyToMany
    @JoinTable(name = "employee_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    @OneToMany(mappedBy = "employee")
    private List<PerformanceReview> performanceReviews;

    public Employee(String name,Double salary){
        this.name=name;
        this.salary=salary;
    }
}
