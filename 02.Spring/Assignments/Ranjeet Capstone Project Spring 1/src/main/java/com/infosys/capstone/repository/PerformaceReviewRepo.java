package com.infosys.capstone.repository;

import com.infosys.capstone.entity.Employee;
import com.infosys.capstone.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformaceReviewRepo extends JpaRepository<PerformanceReview, Long> {
    public List<PerformanceReview> findAllByEmployee(Employee employee);
}
