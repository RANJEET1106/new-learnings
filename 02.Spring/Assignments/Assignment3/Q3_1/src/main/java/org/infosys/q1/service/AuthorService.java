package org.infosys.q1.service;

import org.infosys.q1.beans.Author;
import org.infosys.q1.beans.Book;
import org.infosys.q1.repo.AuthorRepo;
import org.infosys.q1.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceInterface{
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private BookRepo bookRepo;

    @Override
    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(Integer id) {
        return authorRepo.findById(id).get();
    }

    @Override
    public void updateAuthor(Author author) {
        int id=author.getId();
        Optional<Author> optionalAuthor=authorRepo.findById(id);
        if(optionalAuthor.isPresent()){
            authorRepo.save(author);
        }
        else {
            System.out.println("Author not found");
        }
    }

    @Override
    public void deleteAuthor(Integer id) {
        Optional<Author> optionalAuthor=authorRepo.findById(id);
        if (optionalAuthor.isEmpty()) {
            System.out.println("Author not found with id: " + id);
            return;
        }
        Author author=optionalAuthor.get();
        List<Book> books=author.getBooks();
        for(Book book:books){
            book.getAuthors().remove(author);
            bookRepo.save(book);
        }
        authorRepo.deleteById(id);
    }
}
