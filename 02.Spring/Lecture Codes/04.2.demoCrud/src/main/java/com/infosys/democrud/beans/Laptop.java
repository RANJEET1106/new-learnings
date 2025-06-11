package com.infosys.democrud.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="laptop")
@NoArgsConstructor
@Getter @Setter
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter int macId;
    @NotBlank(message = "model name can not be empty")
    private @Getter @Setter String modelName;

    public Laptop(String modelName) {
        this.modelName = modelName;
    }



    @Override
    public String toString() {
        return "Laptop{" +
                "macId=" + macId +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
