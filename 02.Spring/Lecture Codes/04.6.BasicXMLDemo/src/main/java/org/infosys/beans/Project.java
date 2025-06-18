package org.infosys.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class Project {
    private String projectName;
    private Department department;
    private List<Employee> employees;
    private Map<String, Integer> resources;

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    @Autowired
    public Project(List<Employee> employees) {
        this.employees = employees;
    }




    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Department getDepartment() {
        return department;
    }

    @Autowired
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", department=" + department +
                ", employeeList=" + employees +
                '}';
    }

    public void showEmployees(){
        employees.forEach(employee -> System.out.println(employee.getEmployeeName()));
    }

    public void showResources(){
        resources.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
