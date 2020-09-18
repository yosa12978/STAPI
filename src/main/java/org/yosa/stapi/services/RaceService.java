package org.yosa.stapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yosa.stapi.domain.Race;
import org.yosa.stapi.exceptions.NotFoundException;
import org.yosa.stapi.repositories.RaceRepository;

import java.util.List;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public List<Race> getAll(){
        return raceRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Race getOne(String id){
        return raceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Race doesn't exist"));
    }

    public Race create(Race race){
        return raceRepository.save(race);
    }

    public List<Race> search(String query){
        return raceRepository.findByNameRegexOrderByIdDesc(query);
    }

    public void delete(String id){
        raceRepository.delete(raceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Race doesn't exist")));
    }

    public boolean isRaceExist(String id){
        return raceRepository.findById(id).isPresent();
    }

    public boolean isRaceNameExist(String name){
        return raceRepository.findByName(name) != null;
    }

    public Race getRaceByName(String name){
        return raceRepository.findByName(name);
    }
}
