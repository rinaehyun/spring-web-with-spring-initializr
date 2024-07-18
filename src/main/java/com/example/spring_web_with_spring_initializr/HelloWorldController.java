package com.example.spring_web_with_spring_initializr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/hello/{name}")
    public String getGreetingWithName(@PathVariable String name) {
        String greetingWithName = "Hello, " + name + "!";
        System.out.println(greetingWithName);
        return greetingWithName;
    }
}
