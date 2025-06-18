package org.infosys;

import org.infosys.beans.Department;
import org.infosys.beans.Employee;
import org.infosys.beans.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Employee employee= (Employee) context.getBean("emp");
        System.out.println("Employee Id: "+employee.getEmployeeId());
        System.out.println("Employee Name: "+employee.getEmployeeName());

        Department department =(Department) context.getBean("depart1");
        System.out.println(department.toString());

        Project project = (Project) context.getBean("project1");
        System.out.println(project.toString());
        project.showEmployees();
        project.showResources();
    }
}
