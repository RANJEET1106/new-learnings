package com.infosys.democrud.repo;


import com.infosys.democrud.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepo extends JpaRepository<Batches, Integer> {
public List<Batches> findByBatchName(String batchName);
public List<Batches> findByBatchStartDateAndBatchEndDate(String startDate, String endDate);
}
