package com.infosys.vehicle.repo;

import com.infosys.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
    List<Vehicle> findByVehicleStatus(String available);

    List<Vehicle> findByVehicleName(String name);
}
