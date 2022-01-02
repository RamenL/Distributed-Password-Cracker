package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    private static final String template = "Hello, Spring";

    @GetMapping("/")
    public String base() {
        return template;
    }
}