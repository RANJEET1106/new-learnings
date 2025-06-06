package com.infosys.democrud.repo;


import com.infosys.democrud.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends JpaRepository<Batches, Integer> {

}
