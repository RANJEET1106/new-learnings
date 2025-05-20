package com.infosys.beans;

public class PaymentService {
    private String service;

    public PaymentService(){
        System.out.println("Inside payment Services");
    }

    public String getService(){
        return this.service;
    }

    public void setService(String service){
        this.service=service;
    }
}
