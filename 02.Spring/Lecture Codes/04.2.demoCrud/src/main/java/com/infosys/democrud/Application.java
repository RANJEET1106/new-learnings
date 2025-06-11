package com.infosys.democrud;

import com.infosys.democrud.beans.Batches;
import com.infosys.democrud.beans.Laptop;
import com.infosys.democrud.beans.Student;
import com.infosys.democrud.services.BatchServices;
import com.infosys.democrud.services.StudentService;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

//    private final BatchServices batchServices;
//
//    public Application(BatchServices batchServices) {
//        this.batchServices = batchServices;
//    }

    @Autowired
    BatchServices batchServices;
    @Autowired
    StudentService studentService;
    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println(appName);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to add ne batch");
        System.out.println("Enter 2 to Add multiple batches");
        System.out.println("Enter 3 to see batch by id");
        System.out.println("Enter 4 to update batch details");
        System.out.println("Enter 5 to get all batches");
        System.out.println("Enter 6 to search with batch name");
        System.out.println("Enter 7 to find by start date and end date");
        System.out.println("Enter 8 to delete batch");
        System.out.println("Enter 9 to fetch all batches using jpql");
        System.out.println("Enter 10 to fetch batch by start date and name using jpql");
        System.out.println("Enter 11 to fetch all batches using native query language");
        System.out.println("Enter 12 to fetch batch by end date and ID using native query language");
        System.out.println("Enter 13 to fetch all student using named query language");
        System.out.println("Enter 14 to fetch student by email using named query language");
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

            case 4:
                System.out.println("Enter batch id to update");
                int updateId = scanner.nextInt();
                batchServices.updateBatchOnBasisOfId(updateId);
                break;

            case 5:
                List<Batches> batches=batchServices.findAllBatches();
                batches.forEach(batch2->System.out.println(batch2));
                break;

            case 6:
                System.out.println("Enter the batch name to search");
                String batchName2 = scanner.next();
                List<Batches> batchesList1=batchServices.findOnBasisOfBatchName(batchName2);
                batchesList1.forEach(batch2->System.out.println(batch2));
                break;

            case 7:
                System.out.println("Enter the start date to search");
                String startDate2 = scanner.next();
                System.out.println("Enter the end date to search");
                String endDate2 = scanner.next();
                batchesList1=batchServices.findAllBatchesByBatchStartDateAndBatchEndDate(startDate2, endDate2);
                batchesList1.forEach(batch2->System.out.println(batch2));


            case 8:
                System.out.println("Enter batch id to delete");
                int deleteId = scanner.nextInt();
                batchServices.deleteBatchById(deleteId);
                break;

            case 9:
                List<Batches> batches9=batchServices.findAllBatchesByBatchesUsingQuery();
                batches9.forEach(batch2->System.out.println(batch2));
                break;

            case 10:

                System.out.println("Enter batch Name");
                String batchName10 = scanner.next();
                System.out.println("Enter batch start date");
                String startDate10 = scanner.next();
                Batches batch10 = batchServices.showBatcheDetailsOnBasisOfStartDate(startDate10,batchName10);
                if(batch10!=null){
                    System.out.println(batch10.toString());
                }
                break;

            case 11:
                List<Batches> batches11=batchServices.showAllBatchesUsingNativeQuery();
                batches11.forEach(batch11->System.out.println(batch11));
                break;

            case 12:
                System.out.println("Enter batch ID");
                Integer batchID12 = scanner.nextInt();
                System.out.println("Enter batch end date");
                String endDate12 = scanner.next();
                Batches batch12 = batchServices.showBatcheDetailsOnBasisOfEndDateNativeQuery(batchID12,endDate12);
                if(batch12!=null){
                    System.out.println(batch12.toString());
                }
                break;

            case 13:
                List<Student> students= studentService.showAllStudents();
                students.forEach(student1->System.out.println(student1.toString()));
                break;

            case 14:
                System.out.println("Enter the email");
                String email = scanner.next();
                Student student= studentService.findByEmail(email);
                if(student!=null){
                    System.out.println(student.toString());
                }
                else {
                    System.out.println("Email not found");
                }
                break;

            case 15:
                Laptop laptop = new Laptop();
                laptop.setMacId(123456);
                laptop.setModelName("HP Probook");
                Student s= new Student("Ranjeet","ranjeet@infosys.com");
                s.setLaptop(laptop);
                System.out.println("Student saved");
                break;
            default:
                System.out.println("Please enter a valid operation");
                break;

        }
    }
}
