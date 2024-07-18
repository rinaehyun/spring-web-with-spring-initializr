package com.example.spring_web_with_spring_initializr;

public class Message {
    // Fields
    private String name;
    private String message;
    private String id;

    // Constructors
    public Message(String name, String message, String id) {
        this.name = name;
        this.message = message;
        this.id = id;
    }

    // Print

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
