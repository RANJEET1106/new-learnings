package org.infosys.q3_2.services;

import org.infosys.q3_2.beans.Order;
import org.infosys.q3_2.beans.Product;
import org.infosys.q3_2.beans.User;
import org.infosys.q3_2.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements OrderServiceInterface {
    @Autowired
    OrderRepo orderRepo;

    @Override
    public void addOrder(User user, List<Product> products) {
        Order order = new Order(LocalDateTime.now());
        order.setUser(user);
        order.setProducts(products);
        orderRepo.save(order);
    }
}
