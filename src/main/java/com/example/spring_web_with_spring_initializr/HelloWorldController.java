package com.example.spring_web_with_spring_initializr;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/messages")
    public String storeMessage(@RequestBody ObjectNode objectNode) {

        String name = objectNode.get("name").asText();
        String message = objectNode.get("message").asText();
        String id = objectNode.get("id").asText();

        Message message1 = new Message(name, message, id);
        List<Message> messages = List.of(message1);
        System.out.println(messages);
        return messages.toString();
    }
}
