package com.infosys.terminal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ftr_terminal")
public class Terminal {
    @Id
    @Column(unique = true, nullable = false)
    private String terminalId;

    private String terminalName;
    private String country;
    private String itemType;
    private String terminalDescription;
    private Integer capacity;
    private Integer availableCapacity;
    private String status;
    private String harborLocation;
}
