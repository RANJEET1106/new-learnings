package com.infosys.terminal.repo;

import com.infosys.terminal.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TerminalRepo extends JpaRepository<Terminal, String> {
    List<Terminal> findByItemType(String type);
}
