package com.example.spring_web_with_spring_initializr.AsterixAPI;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("characters")
public record Character(
        String id,
        String name,
        int age,
        String profession
) {
}
