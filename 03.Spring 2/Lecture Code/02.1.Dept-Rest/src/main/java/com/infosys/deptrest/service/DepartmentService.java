package com.infosys.deptrest.service;

import com.infosys.deptrest.model.Departments;

public interface DepartmentService {
    Departments saveDepartment(Departments departments);
    Departments getDepartmentById(long id);
}
