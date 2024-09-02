package com.example.chacasanova.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWord {
    @GetMapping("/ola")
    public String ola(){
        return "Ola mundo";
    }
}
