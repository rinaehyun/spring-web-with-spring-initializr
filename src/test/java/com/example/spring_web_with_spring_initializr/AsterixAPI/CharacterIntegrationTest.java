package com.example.spring_web_with_spring_initializr.AsterixAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CharacterRepo characterRepo;

    @Test
    @DirtiesContext
    void getAllCharactersTest_whenCharactersDoNotExist_thenReturnEmptyJsonArray() throws Exception {
        // GIVEN

        // WHEN
        mockMvc.perform(get("/asterix/characters"))
                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    []
                 """));
    }

    @Test
    @DirtiesContext
    void getAllCharactersTest_whenGetCharacters_thenReturnJsonArray() throws Exception {
        // GIVEN
        characterRepo.save(new Character("987", "Automatix", 35, "Barden"));

        // WHEN
        mockMvc.perform(get("/asterix/characters"))
                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                       {
                          "id": "987",
                          "name": "Automatix",
                          "age": 35,
                          "profession": "Barden"
                       }
                    ]
                 """));
    }

    @Test
    @DirtiesContext
    void createCharacterTest() throws Exception {
        // GIVEN

        // WHEN
        mockMvc.perform(post("/asterix/character")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "name": "Automatix",
                            "age": 40,
                            "profession": "Barden"
                        }
                        """))
                // THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "name": "Automatix",
                            "age": 40,
                            "profession": "Barden"
                        }
                        """))
                .andExpect(jsonPath("$.id").exists());
    }
}
