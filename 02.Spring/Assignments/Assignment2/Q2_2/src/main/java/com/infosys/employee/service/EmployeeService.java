package com.infosys.employee.service;

import com.infosys.employee.beans.Employee;
import com.infosys.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepo.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void updateRole(Integer id, String role) {
        try {
            Optional<Employee> employee = employeeRepo.findById(id);
            if (employee.isPresent()) {
                Employee employee1 = employee.get();
                employee1.setEmployeeRole(role);
                employeeRepo.save(employee1);
            }
        } catch (Exception e) {
            System.err.println("Employee ID not found "+e);
        }
    }

    @Override
    public void updateSalary(Integer id, Integer salary) {
        try {
            Optional<Employee> employee = employeeRepo.findById(id);
            if (employee.isPresent()) {
                Employee employee1 = employee.get();
                employee1.setEmployeeSalary(salary);
                employeeRepo.save(employee1);
            }
        } catch (Exception e) {
            System.err.println("Employee ID not found "+e);
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(String department) {
        return employeeRepo.findByEmployeeDepartment(department);
    }

    @Override
    public List<Employee> getAllEmployeesWithRole(String role) {
        return employeeRepo.findByEmployeeRole(role);
    }

    @Override
    public List<Employee> getAllEmployeesWithLocation(String location) {
        return employeeRepo.findByEmployeeLocation(location);
    }
}
