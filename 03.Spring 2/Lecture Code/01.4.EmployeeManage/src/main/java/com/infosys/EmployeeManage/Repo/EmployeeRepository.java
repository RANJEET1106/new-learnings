package com.infosys.EmployeeManage.Repo;

import com.infosys.EmployeeManage.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}