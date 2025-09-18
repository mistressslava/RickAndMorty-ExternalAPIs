package org.example.rickandmortyproject.service;

import org.example.rickandmortyproject.model.CharacterData;
import org.example.rickandmortyproject.model.MultiCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RickAndMortyService {

    private final RestClient restClient;

    public RickAndMortyService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }


    public List<CharacterData> getAllCharacters() {
        return restClient.get()
                .uri("/character")
                .retrieve()
                .body(MultiCharacter.class)
                .results();
    }
}
