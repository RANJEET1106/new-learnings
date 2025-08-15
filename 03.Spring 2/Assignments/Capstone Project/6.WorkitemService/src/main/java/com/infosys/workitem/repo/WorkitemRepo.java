package com.infosys.workitem.repo;

import com.infosys.workitem.model.Workitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkitemRepo extends JpaRepository<Workitem,String> {
    List<Workitem> findByUserId(Long userId);
}
