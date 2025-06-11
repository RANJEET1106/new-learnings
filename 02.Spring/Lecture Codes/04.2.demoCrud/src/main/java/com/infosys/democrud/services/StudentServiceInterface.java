package com.infosys.democrud.services;

import com.infosys.democrud.beans.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentServiceInterface {
    public List<Student> showAllStudents();
    public Student findByEmail(String email);
    public void addStudent(Student student);
}
