package com.infosys.department_service.controller;

import com.infosys.department_service.model.Department;
import com.infosys.department_service.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DeptController {
    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        Department department = departmentRepo.findById(id).orElseThrow(()-> new RuntimeException("Department not found"));
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public Department add(@RequestBody Department department) {
        return departmentRepo.save(department);
    }

    @DeleteMapping
    public Department delete(@RequestBody Department department) {
        departmentRepo.delete(department);
        return department;
    }

}
