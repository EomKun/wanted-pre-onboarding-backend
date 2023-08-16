package com.example.board.wantedpreonboardingbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @GetMapping("/test")
    public String Hello() {
        return "Hello, world!";
    }

}
