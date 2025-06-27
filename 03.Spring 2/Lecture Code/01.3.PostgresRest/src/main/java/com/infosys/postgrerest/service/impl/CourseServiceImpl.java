package com.infosys.postgrerest.service.impl;

import com.infosys.postgrerest.Exception.CourseException;
import com.infosys.postgrerest.model.Course;
import com.infosys.postgrerest.repository.CourseRepository;
import com.infosys.postgrerest.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public String createCourse(Course course) {
        courseRepository.save(course);
        return "Successfully created course";
    }

    @Override
    public String updateCourse(Course course) {
        courseRepository.save(course);
        return "Successfully updated course";
    }

    @Override
    public String deleteCourse(Integer courseId) {
        courseRepository.deleteById(courseId);
        return "Successfully deleted course";
    }

    @Override
    public Course getCourse(Integer courseId) {
        if(courseRepository.findById(courseId).isEmpty())
            throw new CourseException(courseId);
        return courseRepository.findById(courseId).get();
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
}
