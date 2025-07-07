package com.infosys.EmployeeManage.controller;

import com.infosys.EmployeeManage.model.Employee;
import com.infosys.EmployeeManage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/employees")

public class EmployeeController {

    @Autowired

    private EmployeeService service;

    @PostMapping

    public Employee create(@RequestBody Employee employee) {

        return service.save(employee);

    }

    @PutMapping("/{id}")

    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {

        return service.update(id, employee);

    }

    @DeleteMapping("/{id}")

    public void delete(@PathVariable Long id) {

        service.delete(id);

    }

    @GetMapping("/{id}")

    public Employee getById(@PathVariable Long id) {

        return service.getById(id);

    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

}
