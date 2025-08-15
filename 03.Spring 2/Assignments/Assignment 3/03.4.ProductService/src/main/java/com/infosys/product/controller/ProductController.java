package com.infosys.product.controller;

import com.infosys.product.model.Product;
import com.infosys.product.model.RatingDto;
import com.infosys.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping("/get")
    public List<Product> searchProducts(@RequestParam String name) {
        return productRepo.findByNameStartingWithIgnoreCase(name);
    }

    @PostMapping("/rate")
    public Product rateProduct(@RequestBody RatingDto ratingDto) {
        Product product = productRepo.findByName(ratingDto.getName());
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        product.setAverageRating((ratingDto.getRating()+product.getAverageRating())/2);
        return productRepo.save(product);
    }

    @GetMapping("{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) {
        return productRepo.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
}
