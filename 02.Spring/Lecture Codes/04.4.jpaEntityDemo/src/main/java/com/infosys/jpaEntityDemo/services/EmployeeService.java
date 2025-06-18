package com.infosys.jpaEntityDemo.services;

import com.infosys.jpaEntityDemo.beans.Employee;
import com.infosys.jpaEntityDemo.dao.EmployeeDao;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeService implements EmployeeDao {
    EntityManagerFactory emf;
    @PersistenceUnit // Express dependancy on entity manager factory
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        EntityManager entityManager = emf.createEntityManager(); // create entity manager object
//        begin transaction to make changes
        entityManager.getTransaction().begin();
        entityManager.persist(employee); //changing entity state from transient to persist
//        persist() is used to save object entity
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public void findEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id to search for: ");
        int id = sc.nextInt();
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        if(employee != null) {
            System.out.println("Employee found successfully "+employee.toString());
        }
        else {
            System.out.println("Employee not found");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateEmail(int id, String email) {
        EntityManager entityManager = emf.createEntityManager(); // create entity manager object
//        begin transaction to make changes
        entityManager.getTransaction().begin();
//        persist() is used to save object entity
        Employee employee = entityManager.find(Employee.class, id);
        if(employee != null) {
            System.out.println("Employee old email "+employee.getEmpEmail());
            employee.setEmpEmail(email);
            System.out.println("Employee new details "+employee.toString());

        }
        else{
            System.out.println("Employee not found");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeEmployee(int id) {
        EntityManager entityManager = emf.createEntityManager(); // create entity manager object
//        begin transaction to make changes
        entityManager.getTransaction().begin();
//        persist() is used to save object entity
        Employee employee = entityManager.find(Employee.class, id);
        if(employee != null) {
            entityManager.remove(employee);
            System.out.println("Employee removed successfully "+employee.toString());
        }
        else{
            System.out.println("Employee not found");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employee> findAllEmployees() {
        String query="Select e from Employee e";
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Employee> empList = entityManager.createQuery(query,Employee.class);
        return empList.getResultList();
    }

    @Override
    public void findByEmail(String email) {
        EntityManager entityManager = emf.createEntityManager();
        List<Employee> employeeList=  entityManager.createNamedQuery("Employee.findByEmail",Employee.class)
                .setParameter("email", email).getResultList();
        if(employeeList.size()>0) {
            employeeList.forEach(employee1 -> System.out.println(employee1.toString()));
        }
        else{
            System.out.println("Employee not found");
        }
    }

    @Override
    public void validateEmployee(int id, String email) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        if(employee != null && employee.getEmpEmail().equals(email)) {
            System.out.println("Employee validated seuccessfully "+employee.toString());
        }
        else {
            System.out.println("Employee not found");
        }
    }
}
