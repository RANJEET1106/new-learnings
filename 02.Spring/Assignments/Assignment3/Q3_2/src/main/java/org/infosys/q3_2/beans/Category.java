package org.infosys.q3_2.beans;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "products")
@Table(name = "category3")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
}
