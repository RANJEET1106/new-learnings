package com.infosys.main;
import com.infosys.beans.Student;
import com.infosys.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setStudentName("Ranjeet");
        System.out.println(s1.getStudentName());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student s2=context.getBean(Student.class);
        Student s3=context.getBean("student103",Student.class);
        }
}