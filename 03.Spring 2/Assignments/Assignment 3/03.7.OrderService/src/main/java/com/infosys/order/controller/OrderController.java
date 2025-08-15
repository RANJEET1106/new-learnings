package com.infosys.order.controller;

import com.infosys.order.model.Orders;
import com.infosys.order.repo.OrderRepo;
import com.infosys.order.repo.OrderResponseDto;
import com.infosys.order.repo.ProductDto;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    WebClient.Builder webClientBuilder;

    @PostMapping("/add/{userId}")
    public OrderResponseDto addOrder(@PathVariable("userId") Long userId, @RequestBody Orders order) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }
        ProductDto productDTO;
        try {
            productDTO = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8080/product/" + order.getProductId())
                    .retrieve()
                    .bodyToMono(ProductDto.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        if (productDTO == null) {
            throw new RuntimeException("Product not found");
        }

        order.setUserId(userId);
        order.setDate(LocalDate.now());
        order.setStatus("ordered");

        double price = calculatePriceWithDiscount(productDTO.getPrice(), productDTO.getDiscount());
        OrderResponseDto  orderResponseDto = new OrderResponseDto();
        orderResponseDto.setProductName(productDTO.getName());
        orderResponseDto.setSellerName(productDTO.getSeller());
        orderResponseDto.setPrice(price);
        orderResponseDto.setQuantity(order.getQuantity());
        orderResponseDto.setAmount(order.getQuantity() * price);
        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setDate(order.getDate());

        orderRepo.save(order);
        orderResponseDto.setOrderId(order.getId());
        return orderResponseDto;
    }

    @GetMapping("/get/{userId}")
    public List<OrderResponseDto> getOrder(@PathVariable("userId") Long userId) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        List<Orders> orders = orderRepo.findAllByUserId(userId);
        for (Orders order : orders) {
            ProductDto productDTO;
            try {
                productDTO = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8080/product/" + order.getProductId())
                        .retrieve()
                        .bodyToMono(ProductDto.class)
                        .block();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

            if (productDTO == null) {
                throw new RuntimeException("Product not found");
            }

            double price = calculatePriceWithDiscount(productDTO.getPrice(), productDTO.getDiscount());
            OrderResponseDto  orderResponseDto = new OrderResponseDto();
            orderResponseDto.setOrderId(order.getId());
            orderResponseDto.setProductName(productDTO.getName());
            orderResponseDto.setSellerName(productDTO.getSeller());
            orderResponseDto.setPrice(price);
            orderResponseDto.setQuantity(order.getQuantity());
            orderResponseDto.setAmount(order.getQuantity() * price);
            orderResponseDto.setStatus(order.getStatus());
            orderResponseDto.setDate(order.getDate());

            orderResponseDtos.add(orderResponseDto);
        }

        return orderResponseDtos;
    }

    @PutMapping("/update/{userId}")
    public String updateOrder(@PathVariable("userId") Long userId, @RequestBody Orders order) {
        if (checkIfUserExists(userId)) {
            throw new RuntimeException("User does not exist");
        }
        Orders orders = orderRepo.findById(Math.toIntExact(order.getId())).get();
        orders.setStatus(order.getStatus());
        orderRepo.save(orders);
        return "order updated successfully";
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
