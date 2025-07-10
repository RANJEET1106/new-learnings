package com.infosys.ass1.service;

import com.infosys.ass1.model.Book;

import java.util.List;

public interface BookServiceInterface {
    public String createBook(Book book);
    public Book updateBook(Integer id,Book book);
    public String deleteBook(Integer id);
    public Book getBook(Integer id);
    public List<Book> findAllBooks();
}
