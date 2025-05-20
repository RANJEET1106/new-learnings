package com.infosys.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.infosys.beans.Employee;
import com.infosys.config.AppConfig;

@SpringBootApplication
public class Q3Application {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee employee = context.getBean(Employee.class);

		employee.setId("1");
		employee.setName("RANJEET");
		employee.setDesignation("Manager");
		employee.setSalary(50000);

		System.out.println("Employee Details:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Designation: " + employee.getDesignation());
        System.out.println("Salary: " + employee.getSalary());

        System.out.println("Address Details:");
        System.out.println("Street: " + employee.getAddress().getStreet());
        System.out.println("City: " + employee.getAddress().getCity());
        System.out.println("State: " + employee.getAddress().getState());
        System.out.println("Zipcode: " + employee.getAddress().getZipcode());

		context.close();
	}

}
