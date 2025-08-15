package org.infosys.q3_2.repo;

import org.infosys.q3_2.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
