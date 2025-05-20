package com.infosys.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private String  id, name, designation;
    private Integer salary;
    private Address address;

    public Address getAddress(){
        return address;
    }

    @Autowired
    public void setAddress(Address address){
        this.address=address;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public Integer getSalary() {
        return salary;
    }
    
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    

}
