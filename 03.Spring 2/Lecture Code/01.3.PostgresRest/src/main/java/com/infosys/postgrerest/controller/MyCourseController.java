package com.infosys.postgrerest.controller;

import com.infosys.postgrerest.model.Course;
import com.infosys.postgrerest.model.CourseResponse;
import com.infosys.postgrerest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller ad @ResponseBody
@RequestMapping("/course")
public class MyCourseController {

    CourseService courseService;
    public MyCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

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

    @PostMapping("/addcourse")
    public CourseResponse addCourse(@RequestBody Course course){
        courseService.createCourse(course);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatusCode(200);
        courseResponse.setStatusMessage("Course Added Successfully");
        courseResponse.setResponseDate(java.time.LocalDate.now());
        return courseResponse;
    }

    @PostMapping("/newcourse")
    public ResponseEntity<CourseResponse> addNewCourse(@RequestBody Course course){
        courseService.createCourse(course);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatusCode(200);
        courseResponse.setStatusMessage("Course Added Successfully");
        courseResponse.setResponseDate(java.time.LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).
                header("My header","Rest postgres app")
                .body(courseResponse);
    }

//    @GetMapping("/")
//    public CourseResponse homepage(@RequestHeader("User-Agent") String userAgent){
//        log.info(String.format("Header user agen making request is "))
//    }

    @GetMapping("/searchcourse")
    public Course searchCourse(@RequestParam int courseId){
        return courseService.getCourse(courseId);
    }

    @GetMapping("/allcourse")
    public List<Course> DisplayAllCourse(){
        return courseService.getAllCourse();
    }

    @PutMapping("/update")
    public CourseResponse updateCourse(@RequestBody Course course){
        courseService.updateCourse(course);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatusCode(200);
        courseResponse.setStatusMessage("Course Updated Successfully");
        courseResponse.setResponseDate(java.time.LocalDate.now());
        return courseResponse;
    }

    @DeleteMapping("/delete")
    public CourseResponse deleteCourse(@RequestParam int courseId){
        courseService.deleteCourse(courseId);
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatusCode(200);
        courseResponse.setStatusMessage("Course Deleted Successfully");
        courseResponse.setResponseDate(java.time.LocalDate.now());
        return courseResponse;
    }
}
