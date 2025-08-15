package com.infosys.employee.service;

import com.infosys.employee.beans.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    public void addEmployee(Employee employee);
    public Optional<Employee> getEmployeeById(Integer id);
    public List<Employee>  getAllEmployees();
    public void updateRole(Integer id, String role);
    public void updateSalary(Integer id, Integer salary);
    public void deleteEmployee(Integer id);
    public List<Employee> getAllEmployeesByDepartment(String department);
    public List<Employee> getAllEmployeesWithRole(String role);
    public List<Employee> getAllEmployeesWithLocation(String location);
}
