package org.infosys.q3_2.repo;

import org.infosys.q3_2.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
