package com.infosys.inventory.service;

import java.util.List;
import java.util.Optional;

import com.infosys.inventory.beans.Product;

public interface InventoryServiceInterface {
    public void addProduct(Product product);
    public Optional<Product> findProductById(Integer productId);
    public List<Product> findAllProducts();
    public void updatePrice(Integer productId, Integer newPrice);
    public void updateStock(Integer productId, Integer newQuantity);
    public void deleteProduct(Integer productId);
    public List<Product> findAllProductsByCategory(String category);
    public List<Product> findAllProductPriceBetween(Integer lower,Integer higher);
    public List<Product> findAllProductsInStock();
}
