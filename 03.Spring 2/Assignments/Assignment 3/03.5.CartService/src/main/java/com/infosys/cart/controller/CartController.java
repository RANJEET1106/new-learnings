package com.infosys.cart.controller;

import com.infosys.cart.model.Cart;
import com.infosys.cart.repo.CartRepo;
import com.infosys.cart.repo.CartResponseDto;
import com.infosys.cart.repo.CartSummaryDto;
import com.infosys.cart.repo.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    WebClient.Builder webClientBuilder;

    @PostMapping("/add/{userId}")
    public CartResponseDto addItem(@PathVariable Long userId, @RequestBody Cart cart) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }

        ProductDto productDTO;
        try {
            productDTO = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/product/" + cart.getProductId())
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

        // Check if this product already exists in the user's cart
        Cart existingCartItem = cartRepo.findByUserIdAndProductId(userId, cart.getProductId());

        if (existingCartItem != null) {
            // Update quantity and amount
            int updatedQuantity = existingCartItem.getQuantity() + cart.getQuantity();
            double updatedAmount = price * updatedQuantity;

            existingCartItem.setQuantity(updatedQuantity);
            existingCartItem.setCartOfferPrice(updatedAmount);

            cartRepo.save(existingCartItem);

            CartResponseDto cartResponseDto = new CartResponseDto();
            cartResponseDto.setProductName(productDTO.getName());
            cartResponseDto.setSellerName(productDTO.getSeller());
            cartResponseDto.setQuantity(updatedQuantity);
            cartResponseDto.setPrice(price);
            cartResponseDto.setAmount(updatedAmount);

            return cartResponseDto;

        } else {
            double totalAmount = price * cart.getQuantity();

            cart.setUserId(userId);
            cart.setCartOfferPrice(totalAmount);
            cartRepo.save(cart);

            CartResponseDto cartResponseDto = new CartResponseDto();
            cartResponseDto.setProductName(productDTO.getName());
            cartResponseDto.setSellerName(productDTO.getSeller());
            cartResponseDto.setQuantity(cart.getQuantity());
            cartResponseDto.setPrice(price);
            cartResponseDto.setAmount(totalAmount);

            return cartResponseDto;
        }
    }

    @GetMapping("/get/{userId}")
    public CartSummaryDto getCart(@PathVariable("userId") Long userId) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }
        List<Cart> cartItems = cartRepo.findAllByUserId(userId);
        List<CartResponseDto> cartResponseList = new ArrayList<>();

        double totalAmount = 0.0;
        double totalDeliveryFee = 0.0;

        for (Cart cart : cartItems) {
            ProductDto productDTO;
            try {
                productDTO = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8082/product/" + cart.getProductId())
                        .retrieve()
                        .bodyToMono(ProductDto.class)
                        .block();
            } catch (Exception e) {
                throw new RuntimeException("Failed to fetch product details for productId: " + cart.getProductId());
            }

            if (productDTO == null) {
                continue; // or throw exception if you prefer
            }

            double price = calculatePriceWithDiscount(productDTO.getPrice(), productDTO.getDiscount());
            double amount = price * cart.getQuantity();

            CartResponseDto responseDto = new CartResponseDto();
            responseDto.setProductName(productDTO.getName());
            responseDto.setSellerName(productDTO.getSeller());
            responseDto.setQuantity(cart.getQuantity());
            responseDto.setPrice(price);
            responseDto.setAmount(amount);

            totalAmount += amount;
            totalDeliveryFee += productDTO.getDeliveryFee();

            cartResponseList.add(responseDto);
        }

        CartSummaryDto summary = new CartSummaryDto();
        summary.setCartResponseDto(cartResponseList);
        summary.setTotalAmount(totalAmount);
        summary.setDeliveryFee(totalDeliveryFee);

        return summary;
    }

    @PutMapping("/update/{userId}")
    public CartResponseDto updateCart(@PathVariable Long userId, @RequestBody Cart cart) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }

        Long productId = cart.getProductId();
        Integer quantity = cart.getQuantity();
        Cart cartItem = cartRepo.findByUserIdAndProductId(userId, productId);
        if (cartItem == null) {
            throw new RuntimeException("Product not found in cart");
        }

        if (quantity == 0) {
            cartRepo.delete(cartItem);
            return null; // Or return a response indicating it's deleted
        }

        // Fetch latest product info
        ProductDto productDTO;
        try {
            productDTO = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/product/" + productId)
                    .retrieve()
                    .bodyToMono(ProductDto.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch product info");
        }

        if (productDTO == null) {
            throw new RuntimeException("Product not found");
        }

        double price = calculatePriceWithDiscount(productDTO.getPrice(), productDTO.getDiscount());
        double amount = price * quantity;

        // Update cart
        cartItem.setQuantity(quantity);
        cartItem.setCartOfferPrice(amount);
        cartRepo.save(cartItem);

        // Prepare response
        CartResponseDto responseDto = new CartResponseDto();
        responseDto.setProductName(productDTO.getName());
        responseDto.setSellerName(productDTO.getSeller());
        responseDto.setQuantity(quantity);
        responseDto.setPrice(price);
        responseDto.setAmount(amount);

        return responseDto;
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
