package com.example.spring_web_with_spring_initializr;

public class Message {
    // Fields
    private String name;
    private String message;
    private String id;

    // Constructors
    public Message() {}

    public Message(String name, String message, String id) {
        this.name = name;
        this.message = message;
        this.id = id;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
