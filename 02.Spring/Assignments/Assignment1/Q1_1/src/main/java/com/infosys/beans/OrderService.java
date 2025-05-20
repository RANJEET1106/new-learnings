package com.infosys.beans;

public class OrderService {

    private String customerName;
    private PaymentService paymentService;

    public OrderService() {
        System.out.println("Inside OrderService constructor");
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name){
        this.customerName=name;
    }

    public PaymentService getPaymentService(){
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService){
        this.paymentService=paymentService;
    }
}
