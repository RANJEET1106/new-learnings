package com.infosys.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.beans.Course;
import com.infosys.beans.UniversityService;
import com.infosys.config.AppConfig;

@SpringBootApplication
public class Q3Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UniversityService universityService = context.getBean(UniversityService.class);

        universityService.enrollStudentInCourse(101, 1001);
        universityService.enrollStudentInCourse(101, 1002);
        universityService.enrollStudentInCourse(102, 1001);

        System.out.println("Enrollments:");


        for (var student : universityService.getAllStudents()) {
            System.out.println(student.getStudentName() + " enrolled in: ");
            var courses = universityService.getCoursesByStudent(student.getStudentId());
            for (Course course : courses) {
                System.out.println("  - " + course.getCourseName());
            }
        }

        context.close();
    }

}
