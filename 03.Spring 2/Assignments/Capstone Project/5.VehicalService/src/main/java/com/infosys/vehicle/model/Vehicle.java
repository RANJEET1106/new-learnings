package com.infosys.vehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ftr_vehicle")
public class Vehicle {
    @Id
    @Column(unique = true, nullable = false)
    private String vehicleNumber;
    private String vehicleName;
    private Integer maxLiftingCapacity;
    private Date retireDate;
    private String vehicleStatus;
    private String country;
    private String harborLocation;
}
