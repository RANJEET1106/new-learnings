package com.infosys.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UniversityService {
    
    private List<Student> students;
    private List<Course> courses;
    
    private Map<Integer, List<Course>> enrollmentMap = new HashMap<>();

    
    public UniversityService(List<Student> students, List<Course> courses){
        this.students = students;
        this.courses = courses;
    }

    public void enrollStudentInCourse(Integer studentId, Integer courseId) {
        for (Course course:courses){
            if (course.getCourseId().equals(courseId)){
                enrollmentMap.computeIfAbsent(studentId, k -> new ArrayList<>()).add(course);
            }
        }
    }

    public List<Course> getCoursesByStudent(int studentId){
        return enrollmentMap.getOrDefault(studentId, Collections.emptyList());
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}
