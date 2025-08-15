package com.infosys.library.service;

import com.infosys.library.beans.Book;
import com.infosys.library.repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService implements LibraryServiceInterface{
    @Autowired
    LibraryRepo libraryRepo;

    @Override
    public void addBook(Book book) {
        libraryRepo.save(book);
    }

    @Override
    public Book getBooksByIsbn(String isbn) {
        return libraryRepo.findById(isbn).get();
    }

    @Override
    public void updateBook(Book book) {
        Optional<Book> books = libraryRepo.findById(book.getBookIsbn());
        if(books.isPresent()) {
            libraryRepo.save(book);
        }
        else{
            System.out.println("Book not found");
        }
    }

    @Override
    public void deleteBook(String isbn) {
        libraryRepo.deleteById(isbn);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return libraryRepo.findByBookAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return libraryRepo.findByBookGenre(genre);
    }

    @Override
    public List<Book> getBooksPublishedAfterYear(int year) {
        return libraryRepo.findByBookPublishYearAfter(year);
    }
}

