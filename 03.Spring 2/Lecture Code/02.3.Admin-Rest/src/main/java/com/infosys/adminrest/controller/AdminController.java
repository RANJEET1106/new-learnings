package com.infosys.adminrest.controller;

import com.infosys.adminrest.model.AdminResponse;
import com.infosys.adminrest.model.Course;
import com.infosys.adminrest.proxy.AdminProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adminservices")
public class AdminController {

    @Autowired
    AdminProxy adminProxy;

    @GetMapping("/admin")
    public ResponseEntity<AdminResponse> adminHome(){
        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setHttpStatus(HttpStatus.OK);
        adminResponse.setHttpMessage("Hello from admin service");
        return ResponseEntity.status(HttpStatus.OK).body(adminResponse);
    }

    @GetMapping("/getcourselist")
    public List<Course>  getCourseList(){
        return adminProxy.DisplayAllCourse();
    }

    @GetMapping("/searchcourse")
    public Course searchCourse(@RequestParam int courseId){
        return  adminProxy.SearchCourse(courseId);
    }

}
