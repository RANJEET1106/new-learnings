package com.infosys.wishlist.controller;

import com.infosys.wishlist.model.Wishlist;
import com.infosys.wishlist.repo.ProductDto;
import com.infosys.wishlist.repo.WishListDto;
import com.infosys.wishlist.repo.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wish")
public class WishlistController {
    @Autowired
    private WishlistRepo wishlistRepo;

    @Autowired
    WebClient.Builder webClientBuilder;

    @PostMapping("/add/{userId}")
    public WishListDto addItem(@PathVariable Long userId, @RequestParam Long productId) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }
        ProductDto productDTO;
        try {
            productDTO = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/product/" + productId)
                    .retrieve()
                    .bodyToMono(ProductDto.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        if (productDTO == null) {
            throw new RuntimeException("Product not found");
        }

        // Calculate unit price with discount
        double price = calculatePriceWithDiscount(productDTO.getPrice(), productDTO.getDiscount());
        Wishlist existingItem = wishlistRepo.findByUserIdAndProductId(userId,productId);
        if (existingItem != null) {
            throw new RuntimeException("Product already exists");
        }
        WishListDto wishListDto = new WishListDto();
        wishListDto.setProductName(productDTO.getName());
        wishListDto.setSellerName(productDTO.getSeller());
        wishListDto.setDescription(productDTO.getDescription());
        wishListDto.setPrice(price);

        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        wishlist.setProductId(productId);
        wishlistRepo.save(wishlist);
        return wishListDto;
    }

    @GetMapping("/get/{userId}")
    public List<WishListDto> viewItems(@PathVariable Long userId) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }

        List<Wishlist> allWish= wishlistRepo.findAllByUserId(userId);
        List<WishListDto> wishListDtos = new ArrayList<>();

        for (Wishlist wish : allWish) {
            ProductDto productDTO;
            try {
                productDTO = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8080/product/" + wish.getProductId())
                        .retrieve()
                        .bodyToMono(ProductDto.class)
                        .block();
            } catch (Exception e) {
                throw new RuntimeException("Failed to fetch product details for productId: " + wish.getProductId());
            }

            if (productDTO == null) {
                continue; // or throw exception if you prefer
            }

            double price = calculatePriceWithDiscount(productDTO.getPrice(), productDTO.getDiscount());

            WishListDto wishListDto = new WishListDto();
            wishListDto.setProductName(productDTO.getName());
            wishListDto.setSellerName(productDTO.getSeller());
            wishListDto.setDescription(productDTO.getDescription());
            wishListDto.setPrice(price);


            wishListDtos.add(wishListDto);
        }
        return wishListDtos;
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteItem(@PathVariable Long userId, @RequestParam Long productId) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }
        Wishlist wishlist=wishlistRepo.findByUserIdAndProductId(userId,productId);
        wishlistRepo.delete(wishlist);
        return ("Product with id: " + productId + " deleted successfully from wishlist");
    }

    public boolean checkIfUserExists(Long userId) {
        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/auth/" + userId)
                    .retrieve()
                    .toBodilessEntity()
                    .block(); // we only care about HTTP 200 or error
            return false;
        } catch (WebClientResponseException.NotFound e) {
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error while checking user existence", e);
        }
    }

    public double calculatePriceWithDiscount(double price, double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100.");
        }

        double discountAmount = price * (discountPercentage / 100.0);
        return price - discountAmount;
    }
}
