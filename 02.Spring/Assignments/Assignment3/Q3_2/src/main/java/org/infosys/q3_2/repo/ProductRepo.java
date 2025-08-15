package org.infosys.q3_2.repo;

import org.infosys.q3_2.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
