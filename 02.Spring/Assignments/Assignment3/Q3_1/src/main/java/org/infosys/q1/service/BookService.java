package org.infosys.q1.service;

import org.infosys.q1.beans.Author;
import org.infosys.q1.beans.Book;
import org.infosys.q1.beans.LibraryBranch;
import org.infosys.q1.beans.Publisher;
import org.infosys.q1.repo.AuthorRepo;
import org.infosys.q1.repo.BookRepo;
import org.infosys.q1.repo.LibraryBranchRepo;
import org.infosys.q1.repo.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {
    @Autowired
    BookRepo bookRepo;

    @Override
    public void addBook(Book book, Publisher publisher, List<Author> authors, List<LibraryBranch> libraryBranches) {
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setLibraryBranches(libraryBranches);
        bookRepo.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public void updateBook(Book book) {
        int id= book.getIsbn();
        Optional<Book> bookOptional = bookRepo.findById(id);
        if(bookOptional.isPresent()){
            bookRepo.save(book);
        }
        else {
            System.out.println("Book not found");
        }
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepo.deleteById(id);
    }
}
