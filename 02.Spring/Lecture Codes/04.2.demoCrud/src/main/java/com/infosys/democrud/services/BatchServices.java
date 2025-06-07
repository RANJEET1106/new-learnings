package com.infosys.democrud.services;

import com.infosys.democrud.beans.Batches;
import com.infosys.democrud.repo.BatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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

    @Override
    public void updateBatchOnBasisOfId(Integer batchId){
        try{
            Optional<Batches> batchInfo = batchRepo.findById(batchId);
            Batches batch = batchInfo.get();
            if (batch != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new start date");
                String newStartDate = scanner.nextLine();
                System.out.println("Enter new end date");
                String newEndDate = scanner.nextLine();
                batch.setBatchStartDate(newStartDate);
                batch.setBatchEndDate(newEndDate);
                batchRepo.save(batch);

            }
        } catch (Exception e){
            System.err.println("Batch Id Not Found in update Batch In Services "+e);
        }
    }

    @Override
    public List<Batches> findAllBatches() {
        return batchRepo.findAll();
    }

    @Override
    public void deleteBatchById(Integer batchId) {
        batchRepo.deleteById(batchId);
    }

    @Override
    public List<Batches> findOnBasisOfBatchName(String batchName) {
        return batchRepo.findByBatchName(batchName);
    }

    @Override
    public List<Batches> findAllBatchesByBatchStartDateAndBatchEndDate(String startDate, String endDate) {
        return batchRepo.findByBatchStartDateAndBatchEndDate(startDate, endDate);
    }
}
