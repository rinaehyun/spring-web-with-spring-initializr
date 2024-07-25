package com.example.spring_web_with_spring_initializr.AsterixAPI;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {

    @Query(value="{ 'name' : ?0 }")
    Character findByName(String name);

}
