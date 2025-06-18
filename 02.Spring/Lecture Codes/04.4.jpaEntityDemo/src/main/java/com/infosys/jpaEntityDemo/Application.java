package com.infosys.jpaEntityDemo;

import com.infosys.jpaEntityDemo.beans.Employee;
import com.infosys.jpaEntityDemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
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
		System.out.println("Enter 5 to get all employees");
		System.out.println("Enter 6 to get employee by email using named query");
		System.out.println("Enter 7 to validate Employee using email");


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

			case 4:
				System.out.println("Enter employee id to remove");
				int eid = scanner.nextInt();
				employeeService.removeEmployee(eid);
				break;

			case 5:
				List<Employee>employeeList= employeeService.findAllEmployees();
				employeeList.forEach(employee1 -> System.out.println(employee1.toString()));
				break;

			case 6:
				System.out.println("Enter email to search");
				String email = scanner.next();
				employeeService.findByEmail(email);
				break;

			case 7:
				System.out.println("Enter employee id");
				int validId = scanner.nextInt();
				System.out.println("Enter  mail");
				String validMail = scanner.next();
				employeeService.validateEmployee(validId, validMail);
				break;
		}
	}
}
