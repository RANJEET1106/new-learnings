package com.infosys.demodata.repo;


import com.infosys.demodata.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

// CrudRepo <Object,Data type of primary key>
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    


}
