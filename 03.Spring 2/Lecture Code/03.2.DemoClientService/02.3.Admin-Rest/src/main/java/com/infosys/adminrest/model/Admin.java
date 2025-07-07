package com.infosys.adminrest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;

    @NotEmpty(message = "Admin name required")
    private String adminName;

    @NotEmpty(message = "Admin Password required")
    @Size(min=8, max=16, message="Password must between more than 8 and less than 17")
    private String adminPassword;
}
