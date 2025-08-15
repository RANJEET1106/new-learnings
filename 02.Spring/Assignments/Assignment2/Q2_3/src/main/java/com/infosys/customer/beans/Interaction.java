package com.infosys.customer.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "interactions")
@NoArgsConstructor
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interactionId;
    private @Getter @Setter String interactionDate;
    private @Getter @Setter String interactionFeedback;
    private @Getter @Setter Integer interactionRating;
    private @Getter @Setter String interactionProduct;

    public Interaction(String interactinDate, String interactionFeedback, Integer interactionRating, String interactionProduct) {
        this.interactionDate = interactinDate;
        this.interactionFeedback = interactionFeedback;
        this.interactionRating = interactionRating;
        this.interactionProduct = interactionProduct;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "id=" + interactionId +
                ", date=" + interactionDate +
                ", feedback ='" + interactionFeedback + '\'' +
                ", rating=" + interactionRating +
                ", product='" + interactionProduct + '\'' +
                '}';
    }
}
