package com.infosys.postgrerest.controller;

import com.infosys.postgrerest.model.CourseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller ad @ResponseBody
@RequestMapping("/course")
public class MyCourseController {
    @GetMapping()
    public String myHome(){
        return "Return to spring boot session";
    }

    @GetMapping("/welcome")
    public CourseResponse myWelcome(){
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatusCode(200);
        courseResponse.setStatusMessage("Welcome to Spring Boot REST API");
        courseResponse.setResponseDate(java.time.LocalDate.now());
        return courseResponse;
    }
}
