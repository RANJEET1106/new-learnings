package com.infosys.order.repo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderResponseDto {
    private Long orderId;
    private String productName;
    private String sellerName;
    private Double price;
    private Integer quantity;
    private Double amount;
    private LocalDate date;
    private String status;
}
