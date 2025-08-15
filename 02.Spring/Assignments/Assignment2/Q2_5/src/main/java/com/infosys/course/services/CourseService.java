package com.infosys.course.services;

import com.infosys.course.beans.Course;
import com.infosys.course.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CourseServiceInterface{
    @Autowired
    CourseRepo courseRepo;

    @Override
    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepo.findById(id).get();
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepo.deleteById(id);
    }

    @Override
    public void updateCourseDescription(int id, String description) {

            Optional<Course> optional = courseRepo.findById(id);
            if(optional.isPresent()){
                Course course = optional.get();
                course.setCourseDescription(description);
                courseRepo.save(course);
            }
            else{
                System.out.println("Course not found");
            }

    }

    @Override
    public void updateCourseSchedule(int id, LocalTime schedule) {
        Optional<Course> optional = courseRepo.findById(id);
        if(optional.isPresent()){
            Course course = optional.get();
            course.setCourseSchedule(schedule);
            courseRepo.save(course);
        }
        else{
            System.out.println("Course not found");
        }
    }

    @Override
    public List<Course> getCourseByInstructor(String instructor) {
        return courseRepo.findByCourseInstructor(instructor);
    }

    @Override
    public List<Course> getCourseByCategory(String category) {
        return courseRepo.findByCourseCategory(category);
    }

    @Override
    public List<Course> getCourseBetweenTimes(LocalTime start, LocalTime end) {
        return courseRepo.findByCourseScheduleBetween(start, end);
    }
}
