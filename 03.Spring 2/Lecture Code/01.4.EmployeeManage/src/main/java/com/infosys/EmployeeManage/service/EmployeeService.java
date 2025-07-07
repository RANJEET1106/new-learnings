package com.infosys.EmployeeManage.service;

import com.infosys.EmployeeManage.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee update(Long id, Employee employee);
    void delete(Long id);
    Employee getById(Long id);
    List<Employee> getAll();
}