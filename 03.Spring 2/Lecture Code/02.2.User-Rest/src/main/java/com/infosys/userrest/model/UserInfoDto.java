package com.infosys.userrest.model;


import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="user2")
public class UserInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentId;
}
