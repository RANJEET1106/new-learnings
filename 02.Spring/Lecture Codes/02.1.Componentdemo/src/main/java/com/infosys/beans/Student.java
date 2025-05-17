package com.infosys.beans;

import org.springframework.stereotype.Component;

@Component // will automatically create class
public class Student {

    private  String studentName;
    private  Integer studentID;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }
}
