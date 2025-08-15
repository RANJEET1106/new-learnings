package org.infosys.q3_2.repo;

import org.infosys.q3_2.beans.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
