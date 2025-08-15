package com.infosys.workitem.repo;

import com.infosys.workitem.model.WorkItemVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkItemVehicleRepo extends JpaRepository<WorkItemVehicle,String> {
    List<WorkItemVehicle> findByVehicleNumber(String vehicleNumber);

    Optional<WorkItemVehicle> findByVehicleNumberAndWorkItemId(String vehicleNumber, String workItemId);


}
