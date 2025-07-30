package com.infosys.Entity;

import com.infosys.Service.StudentService;

public class Student {
    StudentService studentService;
    public Student(StudentService studentService) {
        this.studentService = studentService;
    }

    public int getAverageMarks(){
        return studentService.getTotalMArks()/studentService.getTotalStudents();
    }
}
