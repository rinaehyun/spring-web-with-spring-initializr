package com.example.spring_web_with_spring_initializr.externalAPI.model;

import com.example.spring_web_with_spring_initializr.externalAPI.apis.CharacterFromExternalAPI;

import java.util.List;

public record ApiResponse(
        ApiResponseInfo info,
        List<CharacterFromExternalAPI> results
) {

}
