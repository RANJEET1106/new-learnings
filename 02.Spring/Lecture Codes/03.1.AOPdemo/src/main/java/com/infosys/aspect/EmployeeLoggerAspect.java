package com.infosys.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class EmployeeLoggerAspect {
    Logger logger = Logger.getLogger(EmployeeLoggerAspect.class.getName());

    //advice -- when

    @Before("execution(* com.infosys.beans.Employee.joinDate())")
    public void sendOfferLetter(){
        logger.log(Level.INFO,"Please accept offer letter before join date");
    }

    @After("execution(* com.infosys.beans.Employee.endDate())")
    public void fnfletter(){
        logger.log(Level.INFO,"Your full and final letter make sure you clear all pending amount if there ");
    }

    @Around("execution (* com.infosys.beans.Employee.promotionDate(..))")
    public void employeePromotion(){
        logger.log(Level.INFO,"Employee promotion for best performance");
    }

    @AfterThrowing("execution(* com.infosys.beans.Employee.deniedOfferLetter())")
    public void rejection(){
        logger.log(Level.INFO,"Offer letter denied");
    }
}
