package com.infosys.userrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private long id;
    private String deptName;
    private String deptAddress;
    public String deptCode;
}
