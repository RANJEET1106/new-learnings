package com.infosys.cart.repo;

import com.infosys.cart.model.Cart;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Long> {
    List<Cart> findAllByUserId(Long userId);

    Cart findByUserIdAndProductId(Long userId, @NotNull(message = "Every field is mendatory") Long productId);
}
