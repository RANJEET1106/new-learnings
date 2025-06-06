package com.infosys.democrud.services;

import com.infosys.democrud.beans.Batches;
import com.infosys.democrud.repo.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServices implements BatchServiceInterface {
    @Autowired
    BatchRepo batchRepo;

    @Override
    public void addBatch(Batches batch) {
        batchRepo.save(batch);
    }

    @Override
    public  void addMultipleBatches(List<Batches> batches) {
        Iterable<Batches> batchInfo= batchRepo.saveAll(batches);
    }

    @Override
    public Optional<Batches> findBatchById(Integer batchId){
        return batchRepo.findById(batchId);
    }
}
