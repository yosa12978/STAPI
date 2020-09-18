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
import org.yosa.stapi.domain.Race;
import org.yosa.stapi.dtos.RaceDto;
import org.yosa.stapi.services.RaceService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/races")
public class RaceController {
    @Autowired
    private RaceService raceService;
    @Autowired
    private ModelMapper modelMapper;

    private static Logger logger = LoggerFactory.getLogger(RaceController.class);

    @GetMapping("")
    public List<RaceDto> getRaces(){
        List<Race> races = raceService.getAll();
        logger.info("Return races");
        return modelMapper.map(races, new TypeToken<List<RaceDto>>(){}.getType());
    }

    @GetMapping("{id}")
    public RaceDto getRace(@PathVariable String id){
        Race race = raceService.getOne(id);
        logger.info("Return race with id = " + id);
        return modelMapper.map(race, RaceDto.class);
    }

    @GetMapping("search")
    public List<RaceDto> searchRace(@RequestParam("q") String query){
        List<Race> races = raceService.search(query);
        logger.info("Search races with query = " + query);
        return modelMapper.map(races, new TypeToken<List<RaceDto>>(){}.getType());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<RaceDto> createRace(@RequestBody Race race){
        Race createdRace = raceService.create(race);
        logger.info("Created race with id = " + race.getId());
        return new ResponseEntity<>(modelMapper.map(createdRace, RaceDto.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable String id){
        if(!raceService.isRaceExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        raceService.delete(id);
        logger.info("Deleted race with id = " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
