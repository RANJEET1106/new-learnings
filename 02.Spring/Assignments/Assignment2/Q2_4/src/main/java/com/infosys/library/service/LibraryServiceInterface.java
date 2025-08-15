package com.infosys.library.service;

import com.infosys.library.beans.Book;

import java.util.List;

public interface LibraryServiceInterface {
    public void addBook(Book book);
    public Book getBooksByIsbn(String isbn);
    public void updateBook(Book book);
    public void deleteBook(String isbn);
    public List<Book> getBooksByAuthor(String author);
    public List<Book> getBooksByGenre(String genre);
    public List<Book> getBooksPublishedAfterYear(int year);
}
