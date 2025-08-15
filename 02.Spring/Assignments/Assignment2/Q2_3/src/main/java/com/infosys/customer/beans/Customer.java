package com.infosys.customer.beans;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customer")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer customerId;
    private @Getter @Setter String customerName;
    private @Getter @Setter String customerEmail;
    private @Getter @Setter String customerPhone;
    private @Getter @Setter String customerAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="customerId")
    private @Getter @Setter List<Interaction> interactions  = new ArrayList<>();

    public Customer(String customerName, String customerEmail, String customerPhone, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", name='" + customerName + '\'' +
                ", email='" + customerEmail + '\'' +
                ", phone='" + customerPhone + '\'' +
                ", address='" + customerAddress + '\'' +
                ", interactions=" + interactions +
                '}';
    }
}
