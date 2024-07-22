package com.example.spring_web_with_spring_initializr.AsterixAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CharacterService {

    private final CharacterRepo characterRepo;

    public List<Character> findAllCharacters() {
        return characterRepo.findAll();
    }

    public Optional<Character> findCharacterById(String id) {
        return characterRepo.findById(id);
    }

    public Character saveCharacter(NewCharacterDto character) {
        Character characterToSave = new Character(
                UUID.randomUUID().toString(),
                character.name(),
                character.age(),
                character.profession()
        );
        return characterRepo.save(characterToSave);
    }

    public void deleteCharacterById(String id) {
        characterRepo.deleteById(id);
    }

    public Character updateCharacterById(String id, Character newCharacter) {
        Character characterInRepo = characterRepo.findById(id).orElseThrow();   // Instead of Optinal, throw Exceptions ! -> .orElseThrow()
        Character updatedCharacter = characterInRepo
                .withName(newCharacter.name())
                .withProfession(newCharacter.profession())
                .withAge(newCharacter.age());
            return characterRepo.save(updatedCharacter);
    }
}
