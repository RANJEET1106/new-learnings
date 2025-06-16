package com.infosys.jpaEntityDemo;

import com.infosys.jpaEntityDemo.beans.Employee;
import com.infosys.jpaEntityDemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add employee");
		System.out.println("Enter 2 to find employee");
		System.out.println("Enter 3 to update email");
		System.out.println("Enter 4 to remove employee");

		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Enter employee name");
				String name = scanner.next();
				System.out.println("Enter employee mail");
				String mail = scanner.next();

				Employee employee = new Employee(name, mail);
				Employee emp=employeeService.addEmployee(employee);
				System.out.println("Employee saved successfully "+emp.toString());
				break;

			case 2:
				employeeService.findEmployee();
				break;

			case 3:
				System.out.println("Enter employee id");
				int id = scanner.nextInt();
				System.out.println("Enter new mail");
				String newMail = scanner.next();
				employeeService.updateEmail(id, newMail);
				break;
		}
	}
}
