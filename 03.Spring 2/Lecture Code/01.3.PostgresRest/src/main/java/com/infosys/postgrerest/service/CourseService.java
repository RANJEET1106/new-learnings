package com.infosys.postgrerest.service;

import com.infosys.postgrerest.model.Course;

import java.util.List;

public interface CourseService {
    public String createCourse(Course course);
    public String updateCourse(Course course);
    public String deleteCourse(Integer courseId);
    public Course getCourse(Integer courseId);
    public List<Course> getAllCourse();
}
