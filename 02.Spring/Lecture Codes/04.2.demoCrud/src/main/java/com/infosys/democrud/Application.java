package com.infosys.democrud;

import com.infosys.democrud.beans.Batches;
import com.infosys.democrud.services.BatchServices;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final BatchServices batchServices;

    public Application(BatchServices batchServices) {
        this.batchServices = batchServices;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to add ne batch");
        System.out.println("Enter 2 to Add multiple batches");
        System.out.println("Enter 3 to see batch by id");
        System.out.println("Enter 4 to update batch details");
        System.out.println("Enter 5 to delete batch");

        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.println("Enter batch Name");
                String batchName = scanner.next();
                System.out.println("Enter batch start date");
                String startDate = scanner.next();
                System.out.println("Enter batch end date");
                String endDate = scanner.next();

                Batches batch = new Batches(batchName, startDate, endDate);
                batchServices.addBatch(batch);
                break;
            case 2:
                System.out.println("Enter number of batches you want to add");
                int noOfBatches = scanner.nextInt();
                List<Batches> batchesList = new ArrayList<Batches>();
                for (int i = 0; i < noOfBatches; i++) {
                    System.out.println("Enter batch Name");
                    String batchName1 = scanner.next();
                    System.out.println("Enter batch start date");
                    String startDate1 = scanner.next();
                    System.out.println("Enter batch end date");
                    String endDate1 = scanner.next();
                    Batches batch1 = new Batches(batchName1, startDate1, endDate1);
                    batchesList.add(batch1);
                }
                batchServices.addMultipleBatches(batchesList);
                break;

            case 3:
                System.out.println("Enter the batch id to search");
                Integer batchId = scanner.nextInt();
                try {
                    Optional<Batches> optional=batchServices.findBatchById(batchId);
                    Batches batch2=optional.get();
                    System.out.println(batch2.toString());
                }catch (Exception e){
                    System.err.println("Id not found");
                }
                break;
        }
    }
}
