package com.example.spring_web_with_spring_initializr.AsterixAPI;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        Character c2 = new Character("456", "Obelix", 35, "Lieferant");
        List<Character> products = List.of(c1);
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
    }

    @Test
    void updateCharacterByIdTest() {
    }
}