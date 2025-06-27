package com.infosys.postgrerest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mycourse")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @NotBlank(message = "Course name can't be empty")
    @Size(min=5, message = "Course name should be minn 5 chars")
    private String courseName;

    @NotNull(message = "Duration is required")
    private Integer duration;
}
