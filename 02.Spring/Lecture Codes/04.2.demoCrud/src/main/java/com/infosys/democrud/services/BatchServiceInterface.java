package com.infosys.democrud.services;

import com.infosys.democrud.beans.Batches;

import java.util.List;
import java.util.Optional;

public interface BatchServiceInterface {

    public void addBatch(Batches batch);
    public void addMultipleBatches(List<Batches> batchesList);
    public Optional<Batches>findBatchById(Integer batchId);
    public void updateBatchOnBasisOfId(Integer batchId);
    public List<Batches> findAllBatches();
    public void deleteBatchById(Integer batchId);

    public List<Batches> findOnBasisOfBatchName(String batchName);
    public List<Batches> findAllBatchesByBatchStartDateAndBatchEndDate(String startDate, String endDate);

}
