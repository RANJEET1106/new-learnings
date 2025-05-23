package com.infosys.beans;

import com.infosys.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Employee {
    private int empId=10;
    private String empName="RANJEET";

    @Autowired
    private EmployeeService employeeService;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void showDetails(){
        System.out.println("Employee ID is: "+empId);
        System.out.println("Employee name is: "+empName);
    }

    public void joinDate(){
        employeeService.joiningDate();
    }

    public void endDate(){
        employeeService.endDate();
    }

    public void promotionDate(String date){
        System.out.println("Your Promotion date is : "+date);
    }

    public void deniedOfferLetter(){
        throw new RuntimeException("Offer letter is not accepted");
    }

}
