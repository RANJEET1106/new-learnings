package com.infosys.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Every field is mendatory")
    private String name;

    @NotBlank(message = "Every field is mendatory")
    private String description;

    @NotNull(message = "Every field is mendatory")
    private Double price;

    @NotNull(message = "Every field is mendatory")
    private Double discount;

    @NotNull(message = "Every field is mendatory")
    private Double deliveryFee;

    @NotNull(message = "Every field is mendatory")
    private Integer averageRating;

    @NotBlank(message = "Every field is mendatory")
    private String seller;
}
