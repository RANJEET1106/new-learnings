package com.infosys.demo_clientservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingContoller {
    @GetMapping("/home")
    public String home() {
        return "Please rate our service";
    }
}
