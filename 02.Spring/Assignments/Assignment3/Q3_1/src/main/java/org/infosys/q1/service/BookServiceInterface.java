package org.infosys.q1.service;

import org.infosys.q1.beans.Author;
import org.infosys.q1.beans.Book;
import org.infosys.q1.beans.LibraryBranch;
import org.infosys.q1.beans.Publisher;

import java.util.List;

public interface BookServiceInterface {
    public void addBook(Book book, Publisher publisher, List<Author> authors, List<LibraryBranch> libraryBranches);
    public Book getBookById(Integer id);
    public List<Book> getBooks();
    public void updateBook(Book book);
    public void deleteBook(Integer id);
}
