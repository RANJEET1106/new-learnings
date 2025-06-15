package com.infosys.mappingdemo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "student2")
@NoArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer studentId;
    @Column(name = "sname")
    @NotBlank(message = "Enter the student name")
    private @Getter @Setter String studentName;
    @Column(name="semail")
    @Email(message = "Please enter valid email")
    private @Getter @Setter String studentEmail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "dept_id")
    private @Getter @Setter Department department;

    @ManyToMany(targetEntity = Courses.class, cascade = CascadeType.ALL)
    @JoinTable(name="student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))

    private @Getter @Setter List<Courses> courses;

    public Student(String studentName, String studentEmail) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }

}