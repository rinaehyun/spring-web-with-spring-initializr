package com.example.spring_web_with_spring_initializr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String getGreetings() {
        String greeting = "Hello, World!";
        System.out.println(greeting);
        return greeting;
    }
}
