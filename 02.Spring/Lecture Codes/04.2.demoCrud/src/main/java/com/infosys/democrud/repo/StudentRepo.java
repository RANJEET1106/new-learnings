package com.infosys.democrud.repo;

import com.infosys.democrud.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    public List<Student> findAllStudents();
    Student findByEmail(@Param("email") String email);
}
