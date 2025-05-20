package com.infosys.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryService {
    Book book;
    private List<Book> bookList = new ArrayList<>();

    @Autowired // Setter injection
    public void setBook(Book book) {
        System.out.println("Setter injection");
        this.book = book;

        // Optional: initialize with the injected book
        book.setBookName("Default Book");
        book.setBookAuthor("Default Author");
        bookList.add(book);
    }
    
    
    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        bookList.add(newBook);
    }

    public void showBooks() {
        System.out.println("Books in library:");
        for (Book b : bookList) {
            System.out.println("Name of book is: "+b.getBookName());
            System.out.println("name of Author is: "+b.getAuthor());
        }
    }

}
