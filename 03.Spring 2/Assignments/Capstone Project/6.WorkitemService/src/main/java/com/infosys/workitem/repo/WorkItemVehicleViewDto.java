package com.infosys.workitem.repo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkItemVehicleViewDto {
    private String vehicleNumber;
    private String workItemId;
    private String assignedWorkItemStatus;

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
