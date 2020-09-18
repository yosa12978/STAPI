package org.yosa.stapi.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yosa.stapi.domain.Character;
import org.yosa.stapi.dtos.CharacterDto;
import org.yosa.stapi.dtos.CharacterReadDto;
import org.yosa.stapi.services.CharacterService;
import org.yosa.stapi.services.RaceService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private RaceService raceService;
    @Autowired
    private ModelMapper modelMapper;

    private static Logger logger = LoggerFactory.getLogger(CharacterController.class);

    @GetMapping("")
    public List<CharacterDto> getCharacters(){
        List<Character> characters = characterService.getAll();
        logger.info("Return characters");
        return modelMapper.map(characters, new TypeToken<List<CharacterDto>>(){}.getType());
    }

    @GetMapping("{id}")
    public CharacterDto getCharacter(@PathVariable String id){
        Character character = characterService.getOne(id);
        logger.info("Return character with id = " + id);
        return modelMapper.map(character, CharacterDto.class);
    }

    @GetMapping("search")
    public List<CharacterDto> searchCharacters(@RequestParam("q") String query ){
        List<Character> characters = characterService.search(query);
        logger.info("Search characters with query = " + query);
        return modelMapper.map(characters, new TypeToken<List<CharacterDto>>(){}.getType());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<CharacterDto> getCharacter(@RequestBody CharacterReadDto character){
        Character createdCharacter = characterService.create(new Character(character.name, raceService.getRaceByName(character.race)));
        logger.info("Created character with id = " + createdCharacter.getId());
        return new ResponseEntity<>(modelMapper.map(createdCharacter, CharacterDto.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable String id){
        if(!characterService.isCharacterExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        characterService.delete(id);
        logger.info("Deleted character with id = " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
