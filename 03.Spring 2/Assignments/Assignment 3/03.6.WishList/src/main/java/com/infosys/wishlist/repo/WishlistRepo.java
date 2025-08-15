package com.infosys.wishlist.repo;

import com.infosys.wishlist.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepo extends JpaRepository<Wishlist, Long> {
    Wishlist findByUserIdAndProductId(Long userId, Long productId);

    List<Wishlist> findAllByUserId(Long userId);

}
