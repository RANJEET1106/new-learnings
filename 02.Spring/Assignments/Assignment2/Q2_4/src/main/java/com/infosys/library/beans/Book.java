package com.infosys.library.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
    @Id
    private @Getter @Setter String bookIsbn;
    private @Getter @Setter String bookTitle;
    private @Getter @Setter String bookAuthor;
    private @Getter @Setter Integer bookPublishYear;
    private @Getter @Setter String bookGenre;
    private @Getter @Setter boolean bookAvailable;

    public Book(String bookIsbn, String bookTitle, String bookAuthor, Integer bookPublishYear,String bookGenre, boolean bookAvailable) {
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishYear = bookPublishYear;
        this.bookGenre = bookGenre;
        this.bookAvailable = bookAvailable;
    }

    @Override
    public String toString() {
        return "Book ISBN: " + bookIsbn + "'\'Title: " + bookTitle +
                "'\'Author: " + bookAuthor + "'\'Publish Year: " + bookPublishYear +
                "'\'Genre: " + bookGenre + "'\'Availability: " + bookAvailable;
    }
}
