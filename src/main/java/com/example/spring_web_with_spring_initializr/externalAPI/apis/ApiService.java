package com.example.spring_web_with_spring_initializr.externalAPI.apis;

import com.example.spring_web_with_spring_initializr.externalAPI.model.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ApiService {

    private final RestClient restClient;

    public ApiService() {
        restClient = RestClient.builder()
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public List<CharacterFromExternalAPI> loadAllCharacters() {
        ApiResponse responseBody = restClient
                .get()
                .uri("/character")
                .retrieve()
                .body(ApiResponse.class);

        return responseBody.results();
    }
}
