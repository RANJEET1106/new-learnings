package com.infosys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infosys.beans.OrderService;
import com.infosys.beans.PaymentService;

@Configuration
public class AppConfig {
    @Bean
    public PaymentService paymentService(){
        PaymentService paymentService=new PaymentService();
        paymentService.setService("Google Pay");
        return paymentService;
    }

    @Bean
    public OrderService orderService(){
        OrderService orderService= new OrderService();
        orderService.setCustomerName("RANJEET");
        orderService.setPaymentService(paymentService());
        return orderService;
    }
}
