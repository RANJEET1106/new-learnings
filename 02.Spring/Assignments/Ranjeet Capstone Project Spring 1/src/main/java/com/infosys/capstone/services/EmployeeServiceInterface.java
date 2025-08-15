package com.infosys.capstone.services;

import com.infosys.capstone.entity.Department;
import com.infosys.capstone.entity.Employee;
import com.infosys.capstone.entity.PerformanceReview;
import com.infosys.capstone.entity.Project;

import java.util.List;

public interface EmployeeServiceInterface {
    public void addDepartment(Department department);
    public void addEmployee(Employee employee, Long departmentId);
    public void addProject(Project project);
    public void assignProject(Long employeeId, List<Long> projectIds);
    public void addReview(PerformanceReview review, Long employeeId);
    public void showAllReviews(Long employeeId);
}
