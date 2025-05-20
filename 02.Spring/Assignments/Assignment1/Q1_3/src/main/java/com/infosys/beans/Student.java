package com.infosys.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String studentName;
    private int studentId;

    public Student(){
        System.out.println("Student Constructor Called");
    }

    public Student(String name, int id) {
        this.studentName = name;
        this.studentId = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

}
