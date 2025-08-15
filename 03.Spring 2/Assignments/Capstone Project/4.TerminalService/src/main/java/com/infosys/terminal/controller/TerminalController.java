package com.infosys.terminal.controller;

import com.infosys.terminal.model.Terminal;
import com.infosys.terminal.repo.TerminalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terminal")
public class TerminalController {

    @Autowired
    private TerminalRepo terminalRepo;

    @PostMapping("/add")
    public Terminal addTerminal(@RequestBody Terminal terminal) {
        return terminalRepo.save(terminal);
    }

    @PutMapping("/update")
    public Terminal updateTerminal(@RequestBody Terminal terminal) {
        Terminal existing = terminalRepo.findById(terminal.getTerminalId())
                .orElseThrow(() -> new RuntimeException("Terminal not found"));
        existing.setTerminalName(terminal.getTerminalName());
        existing.setCountry(terminal.getCountry());
        existing.setItemType(terminal.getItemType());
        existing.setTerminalDescription(terminal.getTerminalDescription());
        existing.setCapacity(terminal.getCapacity());
        existing.setAvailableCapacity(terminal.getAvailableCapacity());
        existing.setStatus(terminal.getStatus());
        existing.setHarborLocation(terminal.getHarborLocation());
        return terminalRepo.save(existing);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTerminal(@PathVariable String id) {
        terminalRepo.deleteById(id);
        return "Terminal deleted successfully";
    }

    @GetMapping("/get/{id}")
    public Terminal getTerminalById(@PathVariable String id) {
        return terminalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Terminal not found"));
    }

    @GetMapping("/type/{type}")
    public List<Terminal> getTerminalByType(@PathVariable String type) {
        return terminalRepo.findByItemType(type);
    }

    @PatchMapping("/status/{id}")
    public Terminal updateTerminalStatus(@PathVariable String id, @RequestParam String status) {
        Terminal terminal = terminalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Terminal not found"));
        terminal.setStatus(status);
        return terminalRepo.save(terminal);
    }
}

