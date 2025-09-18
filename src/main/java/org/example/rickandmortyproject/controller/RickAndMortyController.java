package org.example.rickandmortyproject.controller;

import org.example.rickandmortyproject.model.Character;
import org.example.rickandmortyproject.model.CharacterData;
import org.example.rickandmortyproject.service.RickAndMortyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RickAndMortyController {
    private final RickAndMortyService service;

    public RickAndMortyController(RickAndMortyService service) {
        this.service = service;
    }

    @GetMapping("/characters")
    public List<CharacterData> getAllCharacters() {
        return service.getAllCharacters();
    }
}
