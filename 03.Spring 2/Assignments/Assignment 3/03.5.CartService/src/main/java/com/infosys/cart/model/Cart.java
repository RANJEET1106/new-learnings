package com.infosys.cart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Every field is mendatory")
    private Long productId;

    @NotNull(message = "Every field is mendatory")
    private Long userId;

    @NotNull(message = "Every field is mendatory")
    private Integer quantity;

    @NotNull(message = "Every field is mendatory")
    private Double cartOfferPrice;
}
