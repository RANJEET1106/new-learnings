package com.infosys.main;

import com.infosys.beans.Employee;
import com.infosys.beans.Project;
import com.infosys.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee employee=context.getBean(Employee.class);
        employee.setId(101);
        employee.setName("RANJEET");

        System.out.println(employee.getId() + " " + employee.getName());
        Employee employee1= new Employee();
        Employee employee2= new Employee(102,"Yash");
        System.out.println(employee1.getId() + " " + employee1.getName());
        System.out.println(employee2.getId() + " " + employee2.getName());
        System.out.println(employee2.toString());


        Project project=context.getBean(Project.class);
        project.setProjectName("Infosys Finacle");
        project.setProjectTeamName("Finacle");
        System.out.println(project.toString());

        context.close();
    }
}
