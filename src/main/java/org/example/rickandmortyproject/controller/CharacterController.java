package org.example.rickandmortyproject.controller;

import org.example.rickandmortyproject.model.CharacterData;
import org.example.rickandmortyproject.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterController {
    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping("/characters")
    public List<CharacterData> getAllCharacters() {
        return service.getAllCharacters();
    }

    @GetMapping("/characters/{id}")
    public CharacterData getCharacterById(@PathVariable String id) {
        return service.getCharacterById(id);
    }

    @GetMapping(value = "/characters", params = "status")
    public List<CharacterData> getCharactersByStatus(@RequestParam String status) {
        return service.getCharactersByStatus(status);
    }
}
