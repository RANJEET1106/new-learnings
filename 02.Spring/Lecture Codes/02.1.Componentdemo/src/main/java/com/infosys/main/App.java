package com.infosys.main;

import com.infosys.beans.Student;
import com.infosys.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = context.getBean("student", Student.class);
        student.setStudentName("RANJEET");
        student.setStudentID(7);

        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student ID: " + student.getStudentID());
    }
}
