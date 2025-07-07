package com.infosys.deptrest.service;

import com.infosys.deptrest.model.Departments;
import com.infosys.deptrest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
     private DepartmentRepository departmentRepository;

    @Override
    public Departments saveDepartment(Departments departments) {
        return departmentRepository.save(departments);
    }

    @Override
    public Departments getDepartmentById(long id) {
        return departmentRepository.findById(id).get();
    }
}
