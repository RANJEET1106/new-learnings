package com.infosys.democrud.services;

import com.infosys.democrud.beans.Student;
import com.infosys.democrud.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public List<Student> showAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student findByEmail(String email) {
        Student obj = studentRepo.findByEmail(email);
        if(obj != null){
            return obj;
        }
        return null;
    }

    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
