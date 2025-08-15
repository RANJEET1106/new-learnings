package com.infosys.user.repo;

import lombok.Data;

import java.util.Date;

@Data
public class WorkItemDto {
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
