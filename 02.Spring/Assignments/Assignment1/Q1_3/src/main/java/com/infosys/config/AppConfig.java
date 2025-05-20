package com.infosys.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.infosys.beans.Course;
import com.infosys.beans.Student;

@Configuration
@ComponentScan(basePackages = "com.infosys.beans")
public class AppConfig {

    @Bean
    public List<Student> students(){
        return Arrays.asList(
            new Student("Alice",101),
            new Student("Bob",102),
            new Student("Charlie",103)
        );
    }

    @Bean
    public List<Course> courses(){
        return Arrays.asList(
            new Course("Math",1001),
            new Course("Science",1002),
            new Course("History",1003)
        );
    }
}
