package com.infosys.beans;

public class Project {
    private String projectName;

    public Project(){
        System.out.println("Project created");
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
