package com.infosys.mappingdemo.services;

import com.infosys.mappingdemo.beans.Department;

import java.util.List;

public interface DepartmentServiceInterface {
    public void saveDepartment(Department department);
    public List<Department> getAllDepartments();
    public Department findDepartmentById(Integer deptId);
}
