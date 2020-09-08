package org.yosa.stapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yosa.stapi.domain.Character;
import org.yosa.stapi.services.CharacterService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("")
    public List<Character> getCharacters(){
        return characterService.getAll();
    }

    @PostMapping("")
    public Character getCharacter(@RequestBody Character character){
        return characterService.create(character);
    }

}
