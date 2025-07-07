package com.infosys.product_service.controller;

import com.infosys.product_service.model.Product;
import com.infosys.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> displayProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("product not found"));
        return ResponseEntity.ok(product);
    }
}
