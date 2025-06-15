package com.infosys.mappingdemo.repo;

import com.infosys.mappingdemo.beans.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Integer> {
}
