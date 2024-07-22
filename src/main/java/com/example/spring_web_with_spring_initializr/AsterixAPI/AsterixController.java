package com.example.spring_web_with_spring_initializr.AsterixAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asterix")
public class AsterixController {

    private final CharacterRepo characterRepo;

    public AsterixController(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        List<Character> allCharacters = characterRepo.findAll();
        return allCharacters;
    }

    @GetMapping("/character/{id}")
    public Optional<Character> getCharacterById(@PathVariable String id) {
        return characterRepo.findById(id);
    }

    @GetMapping("/character")
    public String getCharacterByProperties(
            @RequestParam(value = "name") String name
            //@RequestParam(value = "age") int age
            //@RequestParam("profession") String profession
    ) {
        return "Hello";
        //return characterRepo.findByName(name);
    }

    @PostMapping("/character")
    public Character createCharacter(@RequestBody Character character) {
        return characterRepo.save(character);
    }

    @DeleteMapping("/character/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterRepo.deleteById(id);
    }

    @PutMapping("/characters/{id}")
    public Character updateCharater(@PathVariable String id, @RequestBody Character newCharacter) {
        characterRepo.findById(id)
                .map(character -> {
                    character.withName(newCharacter.name());
                    character.withAge(newCharacter.age());
                    character.withProfession(newCharacter.profession());
                    return characterRepo.save(character);
                });
        return characterRepo.save(newCharacter);
    }
}
