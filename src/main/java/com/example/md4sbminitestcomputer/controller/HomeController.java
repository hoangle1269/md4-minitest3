package com.example.md4sbminitestcomputer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage() {
        return "home"; // This will resolve to src/main/resources/templates/home.html
    }
}
