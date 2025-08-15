package com.infosys.user.controller;

import com.infosys.user.model.User;
import com.infosys.user.repo.UserRepo;
import com.infosys.user.repo.WorkItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        User u = userRepo.findById(user.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmailId(user.getEmailId());
        u.setMobileNumber(user.getMobileNumber());
        u.setPassword(user.getPassword()); // Consider encoding if needed
        u.setNationality(user.getNationality());
        u.setPassportNumber(user.getPassportNumber());
        u.setPermanentAddress(user.getPermanentAddress());
        u.setOfficeAddress(user.getOfficeAddress());
        u.setPersonalIdentificationNumber(user.getPersonalIdentificationNumber());
        return userRepo.save(u);
    }

    @GetMapping("/get/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userRepo.deleteById(userId);
        return "User deleted successfully";
    }

    private static final String WORKITEM_BASE_URL = "http://localhost:8080/workitem"; // Adjust as needed

    @PostMapping("/createWorkItem")
    public ResponseEntity<WorkItemDto> createWorkItem(@RequestBody WorkItemDto workItem) {
        WorkItemDto createdWorkItem = webClientBuilder.build()
                .post()
                .uri(WORKITEM_BASE_URL + "/create")
                .bodyValue(workItem)
                .retrieve()
                .bodyToMono(WorkItemDto.class)
                .block();

        return ResponseEntity.ok(createdWorkItem);
    }

    @PutMapping("/updateWorkItem/{id}")
    public ResponseEntity<WorkItemDto> updateWorkItem(@PathVariable String id, @RequestBody WorkItemDto workItem) {
        WorkItemDto createdWorkItem = webClientBuilder.build()
                .put()
                .uri(WORKITEM_BASE_URL + "/update/" + id)
                .bodyValue(workItem)
                .retrieve()
                .bodyToMono(WorkItemDto.class)
                .block();

        return ResponseEntity.ok(createdWorkItem);
    }

}
