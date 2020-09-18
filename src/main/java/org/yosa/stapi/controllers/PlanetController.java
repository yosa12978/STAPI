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
import org.yosa.stapi.domain.Planet;
import org.yosa.stapi.domain.Race;
import org.yosa.stapi.dtos.PlanetDto;
import org.yosa.stapi.dtos.PlanetReadDto;
import org.yosa.stapi.services.PlanetService;
import org.yosa.stapi.services.RaceService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;
    @Autowired
    private RaceService raceService;
    @Autowired
    private ModelMapper modelMapper;

    private static Logger logger = LoggerFactory.getLogger(PlanetController.class);

    @GetMapping("")
    public List<PlanetDto> getPlanets(){
        List<Planet> planets = planetService.getAll();
        logger.info("Return planets");
        return modelMapper.map(planets, new TypeToken<List<PlanetDto>>(){}.getType());
    }

    @GetMapping("{id}")
    public PlanetDto getPlanet(@PathVariable String id){
        Planet planet = planetService.getOne(id);
        logger.info("Return planet with id = " + id);
        return modelMapper.map(planet, PlanetDto.class);
    }

    @GetMapping("search")
    public List<PlanetDto> searchPlanets(@RequestParam("q") String query){
        List<Planet> planets = planetService.search(query);
        logger.info("Search planets with query = " + query);
        return modelMapper.map(planets, new TypeToken<List<PlanetDto>>(){}.getType());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<PlanetDto> createPlanet(@RequestBody PlanetReadDto planet){

        List<Race> races = new ArrayList<Race>();
        planet.race.forEach(e -> races.add(raceService.getRaceByName(e)));
        Planet newPlanet = new Planet(planet.title, races);

        Planet createdPlanet = planetService.create(newPlanet);
        logger.info("Created planet with id = " + createdPlanet.getId());
        return new ResponseEntity<>(modelMapper.map(createdPlanet, PlanetDto.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable String id){
        if(!planetService.isPlanetExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        planetService.delete(id);
        logger.info("Deleted planet with id = " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
