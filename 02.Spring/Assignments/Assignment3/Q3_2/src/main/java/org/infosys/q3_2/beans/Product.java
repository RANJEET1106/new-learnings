package org.infosys.q3_2.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

@Table(name = "product3")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_categories3",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
