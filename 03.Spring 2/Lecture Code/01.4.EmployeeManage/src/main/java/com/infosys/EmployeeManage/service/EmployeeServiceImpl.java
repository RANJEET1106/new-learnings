package com.infosys.EmployeeManage.service;

import com.infosys.EmployeeManage.exception.EmployeeException;
import com.infosys.EmployeeManage.model.Employee;
import com.infosys.EmployeeManage.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        Employee existing = repository.findById(id).orElseThrow();
        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Employee getById(Long id) {
        if(repository.findById(id).isEmpty())
            throw new EmployeeException(id);
        return repository.findById(id).get();
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }
}
