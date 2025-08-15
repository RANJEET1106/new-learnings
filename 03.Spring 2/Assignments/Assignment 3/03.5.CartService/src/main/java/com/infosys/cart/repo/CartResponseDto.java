package com.infosys.cart.repo;

import lombok.Data;

@Data
public class CartResponseDto {
    private String productName;

    private String sellerName;

    private Integer quantity;

    private Double price;

    private Double Amount;
}
