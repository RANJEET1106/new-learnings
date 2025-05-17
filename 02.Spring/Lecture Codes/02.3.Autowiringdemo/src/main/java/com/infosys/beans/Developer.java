package com.infosys.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
DI : setter,constructor
 @Autowire: field,setter method , constructors
 It is used to autowire the beans at the run time by Spring Dependancy Injection mechanism
*/
@Component
public class Developer {
    private String developerName;
    private String teamName;

//    required=false will help to avoid no such bin defination exception
//    if bin is not available in autowire process

    @Autowired(required=false) // autowiring
    private Project project;

//    @Autowired // Constructor auto wiring
//    public Developer(Project project) {
//        System.out.println("Developer constructor called");
//        this.project = project;
//    }
    public Project getProject() {
        return project;
    }

//    @Autowired  // Setter auto wiring
    public void setProject(Project project) {
        this.project = project;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
