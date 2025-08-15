package com.infosys.course.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "course")
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer courseId;
    @Getter @Setter private String courseName;
    @Getter @Setter private String courseDescription;
    @Getter @Setter private String courseInstructor;
    @Getter @Setter private String courseCategory;
    @Getter @Setter private LocalTime courseSchedule;

    public Course(String courseName, String courseDescription, String courseInstructor, String courseCategory, LocalTime courseSchedule) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseInstructor = courseInstructor;
        this.courseCategory = courseCategory;
        this.courseSchedule = courseSchedule;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseId +
                ", courseTitle='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseInstructor='" + courseInstructor + '\'' +
                ", category='" + courseCategory + '\'' +
                ", schedule=" + courseSchedule +
                '}';
    }
}
