package com.infosys.userrest.repository;

import com.infosys.userrest.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterfaceRepository extends JpaRepository<UserInfo, Long> {
}
