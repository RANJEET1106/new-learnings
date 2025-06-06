package com.infosys.democrud.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="batch")
@NoArgsConstructor
public class Batches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Size(min=3, message = "Batch Id mush have 3 characters")
    private  @Getter @Setter int batchId;

    /*
        @NotNull: check if given field is not null
        it will allow 0 and empty values

        @NotEmpty
    */


    @NotBlank(message = "Batch name can not be empty")
    private  @Getter @Setter String batchName;
    @NotBlank(message = "Batch start date can not be empty")
    private  @Getter @Setter String batchStartDate ;
    private  @Getter @Setter String batchEndDate ;

    public Batches(String batchName, String batchStartDate, String batchEndDate) {
        this.batchName = batchName;
        this.batchStartDate = batchStartDate;
        this.batchEndDate = batchEndDate;
    }

    @Override
    public String toString() {
        return "Batches{"+"batchId"+batchId+
                ", batchName="+batchName+'\''+
                ",batchStartDate=" + batchStartDate +'\''+
                ",batchEndDate=" + batchEndDate +'\''+ '}';
    }
}
