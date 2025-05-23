package com.infosys.services;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmployeeService implements EmployeeRepo{
    @Override
    public void joiningDate() {
        System.out.println("Joining date is "+new Date());
    }

    @Override
    public void endDate() {
        System.out.println("End date is 21-05-2026");
    }
}
