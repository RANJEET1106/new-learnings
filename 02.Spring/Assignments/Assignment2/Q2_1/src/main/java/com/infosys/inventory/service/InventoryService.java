package com.infosys.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.inventory.beans.Product;
import com.infosys.inventory.repo.InventoryRepo;

@Service
public class InventoryService implements InventoryServiceInterface {

    @Autowired
    InventoryRepo inventoryRepo;

    @Override
    public void addProduct(Product product) {
        inventoryRepo.save(product);
    }
    @Override
    public Optional<Product> findProductById(Integer productId) {
        return inventoryRepo.findById(productId);
    }
    @Override
    public List<Product> findAllProducts() {
        return inventoryRepo.findAll();
    }
    @Override
    public void updatePrice(Integer productId, Integer newPrice) {
        try {
            Optional<Product> product = inventoryRepo.findById(productId);
            Product tempProduct = product.get();
            if (product != null) {
                tempProduct.setProductPrice(newPrice);
                inventoryRepo.save(tempProduct);
            }
        } catch (Exception e) {
            System.err.println("Product Id Not Found " + e);
        }
    }
    @Override
    public void updateStock(Integer productId, Integer newQuantity) {
        try {
            Optional<Product> product = inventoryRepo.findById(productId);
            Product tempProduct = product.get();
            if (product != null) {
                tempProduct.setProductStock(newQuantity);
                inventoryRepo.save(tempProduct);
            }
        } catch (Exception e) {
            System.err.println("Product Id Not Found " + e);
        }
    }
    @Override
    public void deleteProduct(Integer productId) {
        inventoryRepo.deleteById(productId);
    }
    @Override
    public List<Product> findAllProductsByCategory(String catagory) {
        return inventoryRepo.findByProductCatagory(catagory);
    }
    @Override
    public List<Product> findAllProductPriceBetween(Integer lower, Integer higher) {
        return inventoryRepo.findByProductPriceBetween(lower, higher);
    }
    @Override
    public List<Product> findAllProductsInStock() {
        return inventoryRepo.findByProductStockGreaterThan(0);
    }
}
