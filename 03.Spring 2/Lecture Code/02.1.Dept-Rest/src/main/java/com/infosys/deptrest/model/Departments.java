package com.infosys.deptrest.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="department2")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String deptName;
    private String deptAddress;
    public String deptCode;
}
