package com.infosys.demo_OrederService.repo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class OrderResponseDTO {
    private Long orderId;
    private Long productId;
    private int quantity;
    private double price;

    private String productName;
    private double productPrice;
}
