package org.yosa.stapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("{id}")
    public Character getCharacter(@PathVariable String id){
        return characterService.getOne(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<Character> getCharacter(@RequestBody Character character){
        return new ResponseEntity<>(characterService.create(character), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String id){
        if(!characterService.isCharacterExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        characterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
