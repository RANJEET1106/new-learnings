package com.infosys.auth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "All Fields Are Mendatory")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name contains invalid characters")
    private String name;

    @NotBlank(message = "All Fields Are Mendatory")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one special character"
    )
    private String password;

    @NotBlank(message = "All Fields Are Mendatory")
    private String confirmPassword;

    @NotBlank(message = "All Fields Are Mendatory")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;
}
