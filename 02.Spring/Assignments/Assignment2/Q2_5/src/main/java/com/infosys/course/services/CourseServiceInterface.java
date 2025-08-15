package com.infosys.course.services;

import com.infosys.course.beans.Course;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface CourseServiceInterface {
    public void addCourse(Course course);
    public List<Course> getAllCourses();
    public Course getCourseById(int id);
    public void deleteCourseById(int id);
    public void updateCourseDescription(int id, String description);
    public void updateCourseSchedule(int id, LocalTime schedule);
    public List<Course> getCourseByInstructor(String instructor);
    public List<Course> getCourseByCategory(String category);
    public List<Course> getCourseBetweenTimes(LocalTime start, LocalTime end);

}
