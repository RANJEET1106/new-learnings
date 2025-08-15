package com.infosys.course.repo;

import com.infosys.course.beans.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    public List<Course> findByCourseInstructor(String instructor);
    public List<Course> findByCourseCategory(String category);
    public List<Course> findByCourseScheduleBetween(LocalTime start, LocalTime end);
}
