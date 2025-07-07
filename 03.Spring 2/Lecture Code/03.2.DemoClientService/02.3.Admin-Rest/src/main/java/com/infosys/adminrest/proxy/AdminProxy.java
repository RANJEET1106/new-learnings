package com.infosys.adminrest.proxy;

import com.infosys.adminrest.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url="http://localhost:8080/course",value="course")
public interface AdminProxy {

    @GetMapping("/allcourse")
    List<Course> DisplayAllCourse();

    @GetMapping("/searchcourse")
    Course SearchCourse(@RequestParam("courseId") Integer courseId);
}
