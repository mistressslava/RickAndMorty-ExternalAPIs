package org.example.rickandmortyproject.service;

import org.example.rickandmortyproject.model.CharacterData;
import org.example.rickandmortyproject.model.MultiCharacter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CharacterService {

    private final RestClient restClient;

    public CharacterService(RestClient.Builder restClientBuilder) {
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

    public CharacterData getCharacterById(String id) {
        return restClient.get()
                .uri("/character/{id}", id)
                .retrieve()
                .body(CharacterData.class);
    }

    public List<CharacterData> getCharactersByStatus(String status) {
        return restClient.get()
                .uri("/character?status={status}", status)
                .retrieve()
                .body(MultiCharacter.class)
                .results();
    }
}
