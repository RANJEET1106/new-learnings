package com.infosys.mappingdemo.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "course2")
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer courseId;
    private @Getter @Setter String courseName;

    @ManyToMany(mappedBy = "courses")
    private @Getter @Setter List<Student> enrolledStudentList;

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", enrolledStudentList=" + enrolledStudentList +
                '}';
    }
}
