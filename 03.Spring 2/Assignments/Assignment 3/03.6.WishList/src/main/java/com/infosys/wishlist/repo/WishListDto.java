package com.infosys.wishlist.repo;

import lombok.Data;

@Data
public class WishListDto {
    private String productName;
    private String description;
    private String sellerName;
    private Double price;
}
