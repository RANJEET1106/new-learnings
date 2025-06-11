package com.infosys.democrud.repo;


import com.infosys.democrud.beans.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepo extends JpaRepository<Batches, Integer> {
public List<Batches> findByBatchName(String batchName);
public List<Batches> findByBatchStartDateAndBatchEndDate(String startDate, String endDate);

@Query("select batch from Batches batch")
    public List<Batches> findAllBatches();

// don't give space when passing parameter
// Don't give space between :bsd it will give error
@Query("select batch from Batches batch where batch.batchStartDate=:bsd AND batch.batchName=:bn")
// bind parameter using @param
public Batches showBatchOnBasisOfStartDateAndName(@Param("bsd") String startDate, @Param("bn") String batchName);

@Query(value = "select * from batch",nativeQuery = true)
public List<Batches> findAllBatchesUsingNativeQuery();

@Query(value = "select * from batch where batch_id= :id and batch_end_date = :endDate",nativeQuery = true)
    public Batches showAllBatchesOnBasisOfBatchIdAndEndDate(@Param("id") Integer batchId, @Param("endDate") String endDate);


}
