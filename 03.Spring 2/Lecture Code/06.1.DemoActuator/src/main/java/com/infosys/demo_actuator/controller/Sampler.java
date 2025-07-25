package com.infosys.demo_actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampler")
public class Sampler {

    @GetMapping
    public String hello() {
        return "Hello Welcome";
    }
}
