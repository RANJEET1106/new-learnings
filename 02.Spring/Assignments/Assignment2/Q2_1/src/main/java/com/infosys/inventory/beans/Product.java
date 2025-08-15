package com.infosys.inventory.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer productID;

    @NotBlank(message = "Product name can't be blank")
    private @Getter @Setter String productName;

    private @Getter @Setter String productDescription;

    @NotBlank(message = "Product catagory can't be blank")
    private @Getter @Setter String productCatagory;

    @NotNull(message = "Product Price Can't be Blank")
    private @Getter @Setter Integer productPrice;

    @NotNull(message = "Product stock quantitys can't be blank")
    private @Getter @Setter Integer productStock;

    public Product(String name, String catagory, String description, Integer price, Integer stock) {
        this.productCatagory = catagory;
        this.productName = name;
        this.productDescription = description;
        this.productPrice = price;
        this.productStock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCatagory='" + productCatagory + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                '}';
    }
}
