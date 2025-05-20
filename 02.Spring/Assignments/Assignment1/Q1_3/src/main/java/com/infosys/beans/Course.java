package com.infosys.beans;

import org.springframework.stereotype.Component;

@Component
public class Course {

    private String courseName;
    private int courseId;

    public Course(){
        System.out.println("Course Constructor Called");
    }

    public Course(String name, int id) {
        this.courseName = name;
        this.courseId = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseId() {
        return courseId;
    }
}
