package com.example.spring_web_with_spring_initializr.externalAPI.model;

public record ApiResponseInfo(
        int count,
        int pages,
        String next,
        String prev
) {
}
