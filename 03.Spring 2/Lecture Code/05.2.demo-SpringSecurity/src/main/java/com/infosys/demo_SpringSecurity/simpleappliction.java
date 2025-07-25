package com.infosys.demo_SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class simpleappliction {
    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "welcome to spring security session"+ request.getSession().getId();
    }
}
