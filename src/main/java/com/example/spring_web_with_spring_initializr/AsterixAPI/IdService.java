package com.example.spring_web_with_spring_initializr.AsterixAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class IdService {

    public String randomId() {
        return UUID.randomUUID().toString();
    }

}
