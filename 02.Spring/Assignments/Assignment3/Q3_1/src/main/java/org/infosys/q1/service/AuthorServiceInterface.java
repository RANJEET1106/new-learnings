package org.infosys.q1.service;

import org.infosys.q1.beans.Author;

import java.util.List;

public interface AuthorServiceInterface {
    public void addAuthor(Author author);
    public List<Author> getAuthors();
    public Author getAuthorById(Integer id);
    public void updateAuthor(Author author);
    public void deleteAuthor(Integer id);
}
