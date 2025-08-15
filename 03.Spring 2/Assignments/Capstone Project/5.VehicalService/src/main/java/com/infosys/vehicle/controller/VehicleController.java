package com.infosys.vehicle.controller;

import com.infosys.vehicle.model.Vehicle;
import com.infosys.vehicle.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepo vehicleRepo;

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @GetMapping("/available")
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepo.findByVehicleStatus("Available");
    }

    @GetMapping("/by-name/{name}")
    public List<Vehicle> getVehiclesByName(@PathVariable String name) {
        return vehicleRepo.findByVehicleName(name);
    }

    @GetMapping("/by-number/{number}")
    public Vehicle getVehicleByNumber(@PathVariable String number) {
        return vehicleRepo.findById(number).orElse(null);
    }

    @DeleteMapping("/delete/{number}")
    public String deleteVehicle(@PathVariable String number) {
        vehicleRepo.deleteById(number);
        return "Vehicle with number " + number + " deleted successfully.";
    }
}
