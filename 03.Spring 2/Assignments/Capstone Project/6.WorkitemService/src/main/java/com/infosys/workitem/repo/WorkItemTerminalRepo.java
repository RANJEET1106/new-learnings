package com.infosys.workitem.repo;

import com.infosys.workitem.model.WorkItemTerminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkItemTerminalRepo extends JpaRepository<WorkItemTerminal,String> {
}
