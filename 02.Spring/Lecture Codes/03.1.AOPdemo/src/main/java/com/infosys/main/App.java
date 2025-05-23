package com.infosys.main;

import com.infosys.beans.Employee;
import com.infosys.config.AppConfig;
import com.infosys.services.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee employee = context.getBean(Employee.class);

        employee.joinDate();
        employee.promotionDate("21-12-2025");
        employee.endDate();
//        employee.deniedOfferLetter();
    }
}
