package com.infosys.capstone.services;

import com.infosys.capstone.entity.Department;
import com.infosys.capstone.entity.Employee;
import com.infosys.capstone.entity.PerformanceReview;
import com.infosys.capstone.entity.Project;
import com.infosys.capstone.repository.DepartmentRepo;
import com.infosys.capstone.repository.EmployeeRepo;
import com.infosys.capstone.repository.PerformaceReviewRepo;
import com.infosys.capstone.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    PerformaceReviewRepo performaceReviewRepo;

    @Override
    public void addDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public void addEmployee(Employee employee, Long departmentId) {
        Optional<Department> departmentOptional =departmentRepo.findById(departmentId);
        if(departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            employee.setDepartment(department);
            employeeRepo.save(employee);
            System.out.println("Employee added successfully");
        }
        else{
            System.out.println("Department not found");
        }


    }

    @Override
    public void addProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public void assignProject(Long employeeId, List<Long> projectIds) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            List<Project> projects=new ArrayList<>();
            for(Long projectId:projectIds){
                Optional<Project> projectOptional =projectRepo.findById(projectId);
                if(projectOptional.isPresent()) {
                    Project project = projectOptional.get();
                    projects.add(project);
                }
                else {
                    System.out.println("Project not found for id "+projectId);
                }
            }
            employee.setProjects(projects);
            employeeRepo.save(employee);
        }
        else {
            System.out.println("Employee not found");
        }
    }

    @Override
    public void addReview(PerformanceReview review, Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            review.setEmployee(employee);
            review.setReviewDate(LocalDate.now());
            performaceReviewRepo.save(review);
            employee.setRating(review.getRating());
            employeeRepo.save(employee);
            System.out.println("Review added successfully");
        }
        else{
            System.out.println("Employee not found");
        }
    }

    @Override
    public void showAllReviews(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            List<PerformanceReview> performanceReviews= performaceReviewRepo.findAllByEmployee(employee);
            performanceReviews.forEach(performanceReview -> System.out.println(performanceReview.toString()));
        }


    }
}
