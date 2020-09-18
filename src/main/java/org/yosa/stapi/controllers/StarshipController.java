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
import org.yosa.stapi.domain.Starship;
import org.yosa.stapi.dtos.StarshipDto;
import org.yosa.stapi.services.StarshipService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/starships")
public class StarshipController {

    @Autowired
    private StarshipService starshipService;
    @Autowired
    private ModelMapper modelMapper;

    private static Logger logger = LoggerFactory.getLogger(StarshipController.class);

    @GetMapping("")
    public List<StarshipDto> getAll(){
        List<Starship> starships = starshipService.getStarships();
        logger.info("Return starships");
        return modelMapper.map(starships, new TypeToken<List<StarshipDto>>(){}.getType());
    }

    @GetMapping("{id}")
    public StarshipDto getOne(@PathVariable String id){
        Starship starship = starshipService.getStarship(id);
        logger.info("Return starship with id = " + id);
        return modelMapper.map(starship, StarshipDto.class);
    }

    @GetMapping("search")
    public List<StarshipDto> searchStarship(@RequestParam("q") String query){
        List<Starship> starships = starshipService.search(query);
        logger.info("Search starships with query = " + query);
        return modelMapper.map(starships, new TypeToken<List<StarshipDto>>(){}.getType());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<StarshipDto> createStarship(@RequestBody Starship starship){
        Starship createdStarship = starshipService.create(starship);
        logger.info("Created starship with id = " + createdStarship.getId());
        return new ResponseEntity<>(modelMapper.map(createdStarship, StarshipDto.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStarship(@PathVariable String id){
        if(!starshipService.isStarshipExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        starshipService.delete(id);
        logger.info("Deleted starship with id = " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
