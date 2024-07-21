package com.example.spring_web_with_spring_initializr.AsterixAPI;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {
}
