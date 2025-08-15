package com.infosys.cart.repo;

import lombok.Data;

import java.util.List;

@Data
public class CartSummaryDto {
    private List<CartResponseDto> cartResponseDto;
    private Double totalAmount;
    private Double deliveryFee;
}
