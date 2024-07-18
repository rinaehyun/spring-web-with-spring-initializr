package com.example.spring_web_with_spring_initializr;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    private final List<Message> messages;

    public HelloWorldController(List<Message> messages) {
        this.messages = messages;
    }

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

    @PostMapping("/messages")
    @ResponseBody
    public List<Message> storeMessages(@RequestBody Message message) {
        this.messages.add(message);
        System.out.println(this.messages);
        return this.messages;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return this.messages;
    }

    @DeleteMapping("/messages/{id}")
    public List<Message> getMessages(@PathVariable String id) {
        this.messages.removeIf(message -> message.getId().equals(id));
        return this.messages;
    }
}
