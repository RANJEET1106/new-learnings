package com.infosys.workitem.controller;

import com.infosys.workitem.model.WorkItemTerminal;
import com.infosys.workitem.model.WorkItemVehicle;
import com.infosys.workitem.model.Workitem;
import com.infosys.workitem.repo.WorkItemTerminalRepo;
import com.infosys.workitem.repo.WorkItemVehicleRepo;
import com.infosys.workitem.repo.WorkItemVehicleViewDto;
import com.infosys.workitem.repo.WorkitemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workitem")
public class WorkItemController {

    @Autowired
    private WorkitemRepo workItemRepository;

    @Autowired
    private WorkItemTerminalRepo workItemTerminalRepo;

    @Autowired
    private WorkItemVehicleRepo workItemVehicleRepo;

    @PostMapping("/create")
    public Workitem createWorkItem(@RequestBody Workitem workItem) {
        return workItemRepository.save(workItem);
    }

    @PutMapping("/update/{id}")
    public Workitem updateWorkItem(@PathVariable String id, @RequestBody Workitem updatedItem) {
        Workitem existingItem= workItemRepository.findById(id).get();
                    existingItem.setItemName(updatedItem.getItemName());
                    existingItem.setItemType(updatedItem.getItemType());
                    existingItem.setItemDescription(updatedItem.getItemDescription());
                    existingItem.setMessageToRecipient(updatedItem.getMessageToRecipient());
                    existingItem.setQuantity(updatedItem.getQuantity());
                    existingItem.setCollectionCountry(updatedItem.getCollectionCountry());
                    existingItem.setDestinationCountry(updatedItem.getDestinationCountry());
                    existingItem.setOriginHarborLocation(updatedItem.getOriginHarborLocation());
                    existingItem.setSelectedHarborLocations(updatedItem.getSelectedHarborLocations());
                    existingItem.setShippingDate(updatedItem.getShippingDate());
                    existingItem.setAmount(updatedItem.getAmount());
                    return workItemRepository.save(existingItem);

    }

    // 1. Assign Terminal
    @PostMapping("/assign-terminal")
    public ResponseEntity<String> assignTerminal(
            @RequestParam String workItemId,
            @RequestParam String terminalId) {
        WorkItemTerminal wt = new WorkItemTerminal(workItemId, terminalId);
        workItemTerminalRepo.save(wt);
        return ResponseEntity.ok("Terminal assigned successfully.");
    }

    // 2. Allocate Vehicle
    @PostMapping("/allocate-vehicle")
    public ResponseEntity<String> allocateVehicle(
            @RequestParam String workItemId,
            @RequestParam String vehicleNumber,
            @RequestParam String status) {
        WorkItemVehicle vw = new WorkItemVehicle(vehicleNumber, workItemId, status);
        workItemVehicleRepo.save(vw);
        return ResponseEntity.ok("Vehicle allocated successfully.");
    }

    // 3. Fetch Workitem Details By Vehicle Number
//    @GetMapping("/by-vehicle/{vehicleNumber}")
//    public ResponseEntity<List<WorkItemVehicle>> getWorkItemsByVehicle(@PathVariable String vehicleNumber) {
//        List<WorkItemVehicle> items = workItemVehicleRepo.findByVehicleNumber(vehicleNumber);
//        return ResponseEntity.ok(items);
//    }

    @GetMapping("/by-vehicle/{vehicleNumber}")
    public ResponseEntity<List<WorkItemVehicleViewDto>> getWorkItemsByVehicle(@PathVariable String vehicleNumber) {
        List<WorkItemVehicle> vehicleWorkItems = workItemVehicleRepo.findByVehicleNumber(vehicleNumber);

        List<String> workItemIds = vehicleWorkItems.stream()
                .map(WorkItemVehicle::getWorkItemId)
                .toList();

        List<Workitem> workitems = workItemRepository.findAllById(workItemIds);

        Map<String, Workitem> workItemMap = workitems.stream()
                .collect(Collectors.toMap(Workitem::getWorkItemId, wi -> wi));

        List<WorkItemVehicleViewDto> response = vehicleWorkItems.stream()
                .map(vw -> {
                    Workitem wi = workItemMap.get(vw.getWorkItemId());
                    return new WorkItemVehicleViewDto(
                            vw.getVehicleNumber(),
                            vw.getWorkItemId(),
                            vw.getAssignedWorkItemStatus(),
                            wi.getUserId(),
                            wi.getItemName(),
                            wi.getItemType(),
                            wi.getItemDescription(),
                            wi.getMessageToRecipient(),
                            wi.getQuantity(),
                            wi.getCollectionCountry(),
                            wi.getDestinationCountry(),
                            wi.getOriginHarborLocation(),
                            wi.getSelectedHarborLocations(),
                            wi.getShippingDate(),
                            wi.getAmount()
                    );
                })
                .toList();

        return ResponseEntity.ok(response);
    }


    // 4. Fetch Workitem Details By User
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Workitem>> getWorkItemsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(workItemRepository.findByUserId(userId));
    }

    // 5. Fetch All Workitem Details
    @GetMapping("/all")
    public ResponseEntity<List<Workitem>> getAllWorkItems() {
        return ResponseEntity.ok(workItemRepository.findAll());
    }

    // 6. Update Workitem Status
    @PutMapping("/update-status")
    public ResponseEntity<String> updateWorkItemStatus(
            @RequestParam String workItemId,
            @RequestParam String vehicleNumber,
            @RequestParam String status) {
        Optional<WorkItemVehicle> vwOpt =
                workItemVehicleRepo.findByVehicleNumberAndWorkItemId(vehicleNumber, workItemId);
        if (vwOpt.isPresent()) {
            WorkItemVehicle vw = vwOpt.get();
            vw.setAssignedWorkItemStatus(status);
            workItemVehicleRepo.save(vw);
            return ResponseEntity.ok("WorkItem status updated successfully.");
        } else {
            return ResponseEntity.status(404).body("WorkItem-vehicle mapping not found.");
        }
    }
}

