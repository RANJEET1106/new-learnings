package com.infosys.democrud.repo;

import com.infosys.democrud.beans.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop, Long> {
}
