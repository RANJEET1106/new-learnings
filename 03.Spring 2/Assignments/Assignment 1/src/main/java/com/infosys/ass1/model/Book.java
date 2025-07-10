package com.infosys.ass1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer bookId;

    @NotBlank(message = "Book name can't be empty")
    private String bookName;

    @NotBlank(message = "Author can't be empty")
    private String author;
}
