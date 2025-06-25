package com.infosys.postgrerest.repository;

import com.infosys.postgrerest.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
