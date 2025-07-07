package com.infosys.demo_OrederService.controller;

import com.infosys.demo_OrederService.config.WebClientConfig;
import com.infosys.demo_OrederService.model.Order;
import com.infosys.demo_OrederService.repo.OrderRepository;
import com.infosys.demo_OrederService.repo.OrderResponseDTO;
import com.infosys.demo_OrederService.repo.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/placeorder")
    public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order) {
        return webClientBuilder.build().get()
                .uri("http://localhost:8080/products/"+ order.getProductId())
                .retrieve().bodyToMono(ProductDTO.class)
                .map(productDTO ->{
                    OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

                    orderResponseDTO.setQuantity(order.getQuantity());

                    orderResponseDTO.setProductName(productDTO.getName());
                    orderResponseDTO.setProductPrice(productDTO.getPrice());
                    orderResponseDTO.setPrice(order.getQuantity()*productDTO.getPrice());
                    orderRepository.save(order);
                    orderResponseDTO.setOrderId(order.getId());
                    orderResponseDTO.setProductId(productDTO.getId());
                    return ResponseEntity.ok(orderResponseDTO);
                });
    }



}
