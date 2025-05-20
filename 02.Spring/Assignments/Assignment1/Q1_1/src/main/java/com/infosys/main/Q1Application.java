package com.infosys.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.beans.OrderService;
import com.infosys.config.AppConfig;

@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService= context.getBean(OrderService.class);
		System.out.println("Customer name: "+orderService.getCustomerName());
		System.out.println("Payment Service is : "+orderService.getPaymentService().getService());
		context.close();
	}

}
