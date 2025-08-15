package org.infosys.q1.repo;

import org.infosys.q1.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
