package com.infosys.mappingdemo;

import com.infosys.mappingdemo.beans.Courses;
import com.infosys.mappingdemo.beans.Department;
import com.infosys.mappingdemo.beans.Student;
import com.infosys.mappingdemo.services.DepartmentService;
import com.infosys.mappingdemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String departmentName ;
		System.out.println("Enter 1 to add new department");
		System.out.println("Enter 2 to get all departments");
		System.out.println("Enter 3 to add student with course");
		int operation = scanner.nextInt();
		switch (operation) {
			case 1:
				System.out.println("Enter department name");
				departmentName = scanner.next();
				Department department = new Department(departmentName);

				List<Student> slist= new ArrayList<>();
				System.out.println("Enter the number of students to add");
				int n= scanner.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("Enter student name ");
					String studentName = scanner.next();
					System.out.println("Enter email of student ");
					String email = scanner.next();
					Student student = new Student(studentName, email);
					student.setDepartment(department);
					slist.add(student);
				}
				department.setStudentList(slist);
				departmentService.saveDepartment(department);
				break;

			case 3:
				System.out.println("Enter student name ");
				String studentName = scanner.next();
				System.out.println("Enter email of student ");
				String email = scanner.next();
				System.out.println("Enter department id");
				Integer id = scanner.nextInt();

				department = departmentService.findDepartmentById(id);
				List<Courses> courseList = new ArrayList<>();
				System.out.println("Enter number of courses to add");
				int ncourse = scanner.nextInt();
				for(int i=0;i<ncourse;i++){
					System.out.println("Enter course name ");
					String courseName = scanner.next();
					Courses courses = new Courses();
					courses.setCourseName(courseName);
					courseList.add(courses);
				}
				Student student = new Student(studentName, email);
				student.setDepartment(department);
				student.setCourses(courseList);
				studentService.addStudent(student);
				System.out.println("Data saved");
				break;


		}
	}
}
