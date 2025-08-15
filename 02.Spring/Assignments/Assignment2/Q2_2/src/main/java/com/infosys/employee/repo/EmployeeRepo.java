package com.infosys.employee.repo;

import com.infosys.employee.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    public List<Employee> findByEmployeeDepartment(String department);
    public List<Employee> findByEmployeeRole(String role);
    public List<Employee> findByEmployeeLocation(String employeeLocation);
}
