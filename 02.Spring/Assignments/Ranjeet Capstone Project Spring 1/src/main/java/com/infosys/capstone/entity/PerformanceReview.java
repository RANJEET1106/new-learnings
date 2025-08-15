package com.infosys.capstone.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@ToString(exclude = "employee")
@Data
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(1) @Max(5)
    private Integer rating;

    @NotNull
    private LocalDate reviewDate;

    @NotBlank
    private String remarks;

    @ManyToOne
    private Employee employee;

    public PerformanceReview(Integer rating,String remarks) {
        this.rating = rating;
        this.remarks = remarks;
    }


}
