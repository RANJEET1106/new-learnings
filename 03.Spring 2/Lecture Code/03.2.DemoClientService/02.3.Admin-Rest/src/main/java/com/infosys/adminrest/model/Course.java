package com.infosys.adminrest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mycourse")
public class Course {
    private Integer courseId;
    private String courseName;
    private Integer duration;
}