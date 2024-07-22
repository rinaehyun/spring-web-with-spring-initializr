package com.example.spring_web_with_spring_initializr.AsterixAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration
class CharacterServiceTest {

    CharacterRepo characterRepo = mock(CharacterRepo.class);
    IdService idService = mock(IdService.class);
    CharacterService characterService = new CharacterService(characterRepo, idService);

    @Test
    void findAllCharactersTest_EmptyList() {
        // GIVEN

        // WHEN
        List<Character> actual = characterService.findAllCharacters();

        // THEN
        List<Character> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    void findAllCharactersTest() {
        // GIVEN
        Character c1 = new Character("123", "Asterix", 30, "Krieger");
        Character c2 = new Character("456", "Obelix", 35, "Lieferant");
        List<Character> products = List.of(c1, c2);
        when(characterRepo.findAll()).thenReturn(products);

        // WHEN
        List<Character> actual = characterService.findAllCharacters();

        // THEN
        List<Character> expected = List.of(c1, c2);

        verify(characterRepo, times(1)).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findCharacterByIdTest() {
        // GIVEN
        Character c1 = new Character("123", "Asterix", 30, "Krieger");
        when(characterRepo.findById("123")).thenReturn(Optional.of(c1));

        // WHEN
        Character actual = characterService.findCharacterById("123");

        // THEN
        Character expected = new Character("123", "Asterix", 30, "Krieger");

        verify(characterRepo, times(1)).findById("123");
        assertEquals(expected, actual);
    }

    @Test
    void deleteCharacterByIdTest() {
        //TODO: complete .when()
        //doNothing().when(characterRepo.deleteById(id));
        characterService.deleteCharacterById("123");
        verify(characterRepo, times(1)).deleteById("123");
    }

    @Test
    void updateCharacterByIdTest() {
        // GIVEN
        Character c1 = new Character("123", "Asterix", 30, "Krieger");
        Character updatedCharacter = new Character("123", "Obelix", 25, "Krieger");

        when(characterRepo.findById("123")).thenReturn(Optional.of(c1));
        when(characterRepo.save(updatedCharacter)).thenReturn(updatedCharacter);

        // WHEN
        Character actual = characterService.updateCharacterById("123", updatedCharacter);

        // THEN
        verify(characterRepo, times(1)).findById("123");
        verify(characterRepo, times(1)).save(updatedCharacter);
        assertEquals(updatedCharacter, actual);
    }
}