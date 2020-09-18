package org.yosa.stapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yosa.stapi.domain.Planet;
import org.yosa.stapi.exceptions.NotFoundException;
import org.yosa.stapi.repositories.PlanetRepository;

import java.util.List;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepository planetRepository;

    public List<Planet> getAll(){
        return planetRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Planet getOne(String id){
        return planetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Planet doesn't exist"));
    }

    public Planet create(Planet planet){
        return planetRepository.save(planet);
    }

    public List<Planet> search(String query){
        return planetRepository.findByTitleRegexOrderByIdDesc(query);
    }

    public void delete(String id){
        planetRepository.delete(planetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Planet doesn't exist")));
    }

    public boolean isPlanetExist(String id){
        return planetRepository.findById(id).isPresent();
    }
}
