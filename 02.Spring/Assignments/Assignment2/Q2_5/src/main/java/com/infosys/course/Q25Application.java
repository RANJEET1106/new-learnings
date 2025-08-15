package com.infosys.course;

import com.infosys.course.beans.Course;
import com.infosys.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Q25Application implements CommandLineRunner {

	@Autowired
	CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(Q25Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Integer courseId;
		String courseName, courseDescription, courseInstructor, courseCategory;
		LocalTime courseSchedule;
		List<Course> courses ;
		Course course;

		System.out.println("Enter 1 to add a course");
		System.out.println("Enter 2 to view all courses");
		System.out.println("Enter 3 to view a course by ID");
		System.out.println("Enter 4 to delete a course by ID");
		System.out.println("Enter 5 to update course description by ID");
		System.out.println("Enter 6 to update course schedule by ID");
		System.out.println("Enter 7 to view courses by instructor");
		System.out.println("Enter 8 to view courses by category");
		System.out.println("Enter 9 to view courses between two times");

		Integer operator = scanner.nextInt();
		scanner.nextLine();
		switch (operator) {
			case 1:
				System.out.println("Enter course name: ");
				courseName = scanner.nextLine();
				System.out.println("Enter course description: ");
				courseDescription = scanner.nextLine();
				System.out.println("Enter course instructor: ");
				courseInstructor = scanner.nextLine();
				System.out.println("Enter course category: ");
				courseCategory = scanner.nextLine();
				System.out.println("Enter course schedule (HH:mm): ");
				courseSchedule = LocalTime.parse(scanner.nextLine());

				course = new Course(courseName, courseDescription, courseInstructor, courseCategory, courseSchedule);
				courseService.addCourse(course);
				break;

			case 2:
				List<Course> allCourses = courseService.getAllCourses();
				allCourses.forEach(System.out::println);
				break;

			case 3:
				System.out.println("Enter course ID: ");
				courseId = Integer.parseInt(scanner.nextLine());
				course = courseService.getCourseById(courseId);
				System.out.println(course != null ? course : "Course not found.");
				break;

			case 4:
				System.out.println("Enter course ID to delete: ");
				courseId = Integer.parseInt(scanner.nextLine());
				courseService.deleteCourseById(courseId);
				System.out.println("Course deleted successfully (if it existed).");
				break;

			case 5:
				System.out.println("Enter course ID to update description: ");
				courseId = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter new description: ");
				courseDescription = scanner.nextLine();
				courseService.updateCourseDescription(courseId, courseDescription);
				System.out.println("Course description updated.");
				break;

			case 6:
				System.out.println("Enter course ID to update schedule: ");
				courseId = Integer.parseInt(scanner.nextLine());
				System.out.println("Enter new schedule (HH:mm): ");
				courseSchedule = LocalTime.parse(scanner.nextLine());
				courseService.updateCourseSchedule(courseId, courseSchedule);
				System.out.println("Course schedule updated.");
				break;

			case 7:
				System.out.println("Enter instructor name: ");
				courseInstructor = scanner.nextLine();
				List<Course> byInstructor = courseService.getCourseByInstructor(courseInstructor);
				byInstructor.forEach(System.out::println);
				break;

			case 8:
				System.out.println("Enter category: ");
				courseCategory = scanner.nextLine();
				List<Course> byCategory = courseService.getCourseByCategory(courseCategory);
				byCategory.forEach(System.out::println);
				break;

			case 9:
				DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

				System.out.println("Enter start time (HH:mm): ");
				LocalTime startTime = LocalTime.parse(scanner.nextLine(), timeFormatter);

				System.out.println("Enter end time (HH:mm): ");
				LocalTime endTime = LocalTime.parse(scanner.nextLine(), timeFormatter);

				List<Course> timeFilteredCourses = courseService.getCourseBetweenTimes(startTime, endTime);
				timeFilteredCourses.forEach(System.out::println);
				break;
		}
	}
}
