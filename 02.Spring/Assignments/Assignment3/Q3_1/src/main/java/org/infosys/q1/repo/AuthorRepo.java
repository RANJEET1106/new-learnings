package org.infosys.q1.repo;

import org.infosys.q1.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
