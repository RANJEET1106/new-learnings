package com.infosys.wishlist.repo;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double discount;
    private Double deliveryFee;
    private Integer averageRating;
    private String seller;
}
