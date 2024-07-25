package com.example.spring_web_with_spring_initializr.externalAPI.apis;

public record CharacterFromExternalAPI(
        String id,
        String name,
        String status,
        String species
) {
}
