package com.infosys.workitem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ftr_workitem")
public class Workitem {
    @Id
    @Column(unique = true,nullable = false)
    private String workItemId;

    private Long userId;
    private String itemName;
    private String itemType;
    private String itemDescription;
    private String messageToRecipient;
    private String quantity;
    private String collectionCountry;
    private String destinationCountry;
    private String originHarborLocation;
    private String selectedHarborLocations;
    private Date shippingDate;
    private Integer amount;
}
