package com.infosys.employee_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long employeeId;
    private String employeeName;
    private double employeeSalary;
    private Long deptId;
    private String deptName;
    private Long managerId;
}
