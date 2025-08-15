package com.infosys.customer.repo;

import com.infosys.customer.beans.Customer;
import com.infosys.customer.beans.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
