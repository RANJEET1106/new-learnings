package com.infosys.capstone;

import com.infosys.capstone.entity.Department;
import com.infosys.capstone.entity.Employee;
import com.infosys.capstone.entity.PerformanceReview;
import com.infosys.capstone.entity.Project;
import com.infosys.capstone.services.BonusService;
import com.infosys.capstone.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication(scanBasePackages = "com.infosys.capstone")
public class CapstoneProjectSpring1Application implements CommandLineRunner {
	@Autowired
	EmployeeService  employeeService;
	@Autowired
	BonusService bonusService;

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean flag=true;
		while(flag){
			System.out.println("Enter 1 to add department");
			System.out.println("Enter 2 to add employee");
			System.out.println("Enterr 3 to add Project");
			System.out.println("Enter 4 to assign project to employee");
			System.out.println("Enter 5 to add performance review");
			System.out.println("Enter 6 to show all review for employee");
			System.out.println("Enter 7 to calculate bonus");


			Scanner sc = new Scanner(System.in);
			String name,string;
			double salary;
			long id;
			int duration, rating;

			Department department;
			Employee employee;
			Project project;
			PerformanceReview performanceReview;

			List<Long> projectIds;

			int operation=sc.nextInt();
			switch (operation) {
				case 1:
					System.out.println("Enter Department name");
					name = sc.next();
					department = new Department(name);
					employeeService.addDepartment(department);
					break;

				case 2:
					System.out.println("Enter Employee name");
					name = sc.next();
					System.out.println("Enter Employee salary");
					salary = sc.nextDouble();
					System.out.println("Enter Department ID of employee");
					id=sc.nextLong();
					employee = new Employee(name, salary);
					employeeService.addEmployee(employee, id);
					break;

				case 3:
					System.out.println("Enter title of project");
					name = sc.next();
					System.out.println("Enter duration of project");
					duration = sc.nextInt();
					project = new Project(name, duration);
					employeeService.addProject(project);
					break;

				case 4:
					System.out.println("Enter ID of employee");
					id = sc.nextLong();
					System.out.println("Enter Project ID's Comma separated");
					string=sc.next();
					projectIds = Arrays.stream(string.split(","))
							.map(String::trim)
							.map(Long::parseLong)
							.toList();
					employeeService.assignProject(id,projectIds);
					break;

				case 5:
					System.out.println("Enter ID of employee");
					id= sc.nextLong();
					System.out.println("Enter the rating");
					rating = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the review");
					string= sc.nextLine();

					performanceReview= new PerformanceReview(rating,string);
					employeeService.addReview(performanceReview, id);
					break;

				case 6:
					System.out.println("Enter the id of employee");
					id= sc.nextLong();
					employeeService.showAllReviews(id);
					break;

				case 7:
					sc.nextLine();
					System.out.println("Employee type Standard/Executive");
					string=sc.nextLine();
					System.out.println("Enter te rating");
					rating=sc.nextInt();
					if(string.equals("Standard")){
						bonusService.standardBonusService(rating);
					}
					else if(string.equals("Executive")){
						bonusService.executiveBonusService(rating);
					}
					else {
						System.out.println("Invalid Input");
					}
					break;
			}
		}

	}
}
