package com.infosys.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.inventory.beans.Product;

import java.util.List;

@Repository
public interface InventoryRepo extends JpaRepository<Product,Integer> {
    public List<Product> findByProductCatagory(String catagory);
    public List<Product> findByProductPriceBetween(Integer lower, Integer higher);
    public List<Product> findByProductStockGreaterThan(Integer stock);
}
