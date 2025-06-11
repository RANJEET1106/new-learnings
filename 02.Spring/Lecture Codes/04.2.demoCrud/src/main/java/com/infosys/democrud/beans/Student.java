package com.infosys.democrud.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Entity
@Table(name = "student")
@NoArgsConstructor

@NamedQuery(
        name = "Student.findAllStudents",
        query = "SELECT s from Student s "
)

@NamedQuery(
        name="Student.findByEmail",
        query = "select s from Student s where s.studentEmail =:email "
)

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int studentId;
    @Column(name = "sname")
    @NotBlank(message = "Enter the student name")
    private @Getter @Setter String studentName;
    @Column(name="semail")
    @Email(message = "Please enter valid email")
    private @Getter @Setter String studentEmail;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Laptop.class)
    @JoinColumn(name = "laptop_id", referencedColumnName = "macId", nullable = true)
    private @Getter @Setter Laptop laptop;

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
