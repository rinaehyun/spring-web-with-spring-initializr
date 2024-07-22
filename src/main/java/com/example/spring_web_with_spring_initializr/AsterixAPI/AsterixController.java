package com.example.spring_web_with_spring_initializr.AsterixAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asterix")
@RequiredArgsConstructor
public class AsterixController {

    private final CharacterService characterService;

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        List<Character> allCharacters = characterService.findAllCharacters();
        return allCharacters;
    }

    @GetMapping("/character/{id}")
    public Character getCharacterById(@PathVariable String id) {
        return characterService.findCharacterById(id);
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
    public Character createCharacter(@RequestBody NewCharacterDto character) {
        return characterService.saveCharacter(character);
    }

    @DeleteMapping("/character/{id}")
    public void deleteCharacter(@PathVariable String id) {
        characterService.deleteCharacterById(id);
    }

    @PutMapping("/characters/{id}")
    public Character updateCharacter(@PathVariable String id, @RequestBody Character newCharacter) {
        return characterService.updateCharacterById(id, newCharacter);
    }
}
