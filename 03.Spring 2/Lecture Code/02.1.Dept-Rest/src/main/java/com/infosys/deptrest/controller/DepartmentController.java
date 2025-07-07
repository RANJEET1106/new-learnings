package com.infosys.deptrest.controller;

import com.infosys.deptrest.model.Departments;
import com.infosys.deptrest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Departments> saveDepartment(@RequestBody Departments departments) {
        Departments savedDepartment = departmentService.saveDepartment(departments);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDepatmentById(@PathVariable("id")  long id) {
        Departments department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
