package com.infosys.config;
import com.infosys.beans.Student;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Primary
    @Bean
    Student student() {
        Student s1=new Student();
        s1.setStudentName("Yash");
        System.out.println(s1.getStudentName());
        return s1;
    }

    @Bean(name="student103")
    Student student1() {
        Student s1=new Student();
        s1.setStudentName("Akalank");
        System.out.println(s1.getStudentName());
        return s1;
    }

}
