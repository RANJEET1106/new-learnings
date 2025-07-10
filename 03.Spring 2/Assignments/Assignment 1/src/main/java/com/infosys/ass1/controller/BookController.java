package com.infosys.ass1.controller;

import com.infosys.ass1.model.Book;
import com.infosys.ass1.model.BookResponse;
import com.infosys.ass1.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        bookService.createBook(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public BookResponse deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return new BookResponse(
                200,
                "Book Deleted Successfully",
                LocalDate.now());
    }

}
