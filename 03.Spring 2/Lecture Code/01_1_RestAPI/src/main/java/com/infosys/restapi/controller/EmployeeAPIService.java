package com.infosys.restapi.controller;

import com.infosys.restapi.model.CloudVendor;
import com.infosys.restapi.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeAPIService {
    Employee employee;

    @GetMapping("{empId}")
    public Employee getEmployee(String empId) {
        return employee;
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        this.employee = employee;
        return "Employee Created Successfully";
    }

    @PutMapping
    public String updateEmployee(@RequestBody Employee employee) {
        this.employee = employee;
        return "Employee Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteEmployee(@PathVariable("vendorId") String vendorId) {
        this.employee = null;
        return "Employee Deleted Successfully";
    }
}
