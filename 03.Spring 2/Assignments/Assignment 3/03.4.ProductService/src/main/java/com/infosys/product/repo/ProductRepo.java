package com.infosys.product.repo;

import com.infosys.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByNameStartingWithIgnoreCase(String prefix);

    Product findByName(String name);
}
