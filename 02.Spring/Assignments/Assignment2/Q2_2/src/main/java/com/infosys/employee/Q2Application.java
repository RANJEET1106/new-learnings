package com.infosys.employee;

import com.infosys.employee.beans.Employee;
import com.infosys.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Q2Application implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(Q2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String employeeName, employeeDepartment, employeeRole, employeeLocation;
		Integer employeeSalary, employeeId;
		Employee employee;
		List<Employee> employees;

		System.out.println("Enter 1 to add new employee");
		System.out.println("Enter 2 to fetch employee by id");
		System.out.println("Enter 3 to fetch all employees");
		System.out.println("Enter 4 to update employee role");
		System.out.println("Enter 5 to update employee salary");
		System.out.println("Enter 6 to delete employee by id");
		System.out.println("Enter 7 to fetch employee by department");
		System.out.println("Enter 8 to fetch employee by role");
		System.out.println("Enter 9 to fetch employee by location");

		Integer operation = scanner.nextInt();
		scanner.nextLine();
		switch (operation) {
			case 1:
				System.out.println("Enter employee name: ");
				employeeName = scanner.next();
				System.out.println("Enter employee department: ");
				employeeDepartment = scanner.next();
				System.out.println("Enter employee role: ");
				employeeRole = scanner.next();
				System.out.println("Enter employee location: ");
				employeeLocation = scanner.next();
				System.out.println("Enter employee salary: ");
				employeeSalary = scanner.nextInt();

				employee = new Employee(employeeName,employeeRole,employeeDepartment,employeeSalary,employeeLocation);
				employeeService.addEmployee(employee);
				break;

			case 2:
				System.out.println("Enter employee id to fetch : ");
				employeeId = scanner.nextInt();

				Optional<Employee> optional= employeeService.getEmployeeById(employeeId);
				if (optional.isPresent()) {
					employee = optional.get();
					System.out.println(employee.toString());
				}
				else{
					System.out.println("Employee not found");
				}
				break;

			case 3:
				employees = employeeService.getAllEmployees();
				for (Employee employee1 : employees) {
					System.out.println(employee1.toString());
				}
				break;

			case 4:
				System.out.println("Enter employee Id to update : ");
				employeeId = scanner.nextInt();
				System.out.println("Enter the new role: ");
				employeeRole = scanner.next();
				employeeService.updateRole(employeeId,employeeRole);
				break;

			case 5:
				System.out.println("Enter employee Id to update : ");
				employeeId = scanner.nextInt();
				System.out.println("Enter the new salary: ");
				employeeSalary = scanner.nextInt();
				employeeService.updateSalary(employeeId,employeeSalary);
				break;

			case 6:
				System.out.println("Enter employee Id to delete : ");
				employeeId = scanner.nextInt();
				employeeService.deleteEmployee(employeeId);
				break;

			case 7:
				System.out.println("Enter department Name to fetch: ");
				employeeDepartment = scanner.next();
				employees = employeeService.getAllEmployeesByDepartment(employeeDepartment);
				for (Employee employee1 : employees) {
					System.out.println(employee1.toString());
				}
				break;

			case 8:
				System.out.println("Enter role to fetch ");
				employeeRole = scanner.next();
				employees= employeeService.getAllEmployeesWithRole(employeeRole);
				for (Employee employee1 : employees) {
					System.out.println(employee1.toString());
				}
				break;

			case 9:
				System.out.println("Enter location to fetch: ");
				employeeLocation = scanner.next();
				employees = employeeService.getAllEmployeesWithLocation(employeeLocation);
				for (Employee employee1 : employees) {
					System.out.println(employee1.toString());
				}
				break;


		}
	}

}
