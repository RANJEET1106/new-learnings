package com.infosys.ass1.service;

import com.infosys.ass1.exception.BookException;
import com.infosys.ass1.model.Book;
import com.infosys.ass1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookServiceInterface{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public String createBook(Book book) {
        bookRepository.save(book);
        return "Book created successfully";
    }

    @Override
    public Book updateBook(Integer id,Book book) {
        if(bookRepository.findById(id).isPresent()){
            Book currentBook=bookRepository.findById(id).get();
            currentBook.setBookName(book.getBookName());
            currentBook.setAuthor(book.getAuthor());
            bookRepository.save(currentBook);
            return currentBook;
        }
        throw new BookException(id);
    }

    @Override
    public String deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }

    @Override
    public Book getBook(Integer id) {
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        }
        throw new BookException(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
