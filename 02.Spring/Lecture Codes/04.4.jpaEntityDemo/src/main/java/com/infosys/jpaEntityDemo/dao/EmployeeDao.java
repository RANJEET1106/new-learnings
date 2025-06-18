package com.infosys.jpaEntityDemo.dao;

import com.infosys.jpaEntityDemo.beans.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    public Employee addEmployee(Employee employee);
    public void findEmployee();
    public void updateEmail(int id, String email);
    public void removeEmployee(int id);
    public List<Employee> findAllEmployees();
    public void findByEmail(String email);
    public void validateEmployee(int id,String email);
}
