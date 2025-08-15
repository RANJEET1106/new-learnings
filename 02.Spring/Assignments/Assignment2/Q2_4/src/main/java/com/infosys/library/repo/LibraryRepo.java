package com.infosys.library.repo;

import com.infosys.library.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo extends JpaRepository<Book, String> {
    List<Book> findByBookAuthor(String author);
    List<Book> findByBookGenre(String genre);
    List<Book> findByBookPublishYearAfter(int year);
}
