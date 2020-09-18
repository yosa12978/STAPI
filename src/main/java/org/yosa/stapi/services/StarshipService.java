package org.yosa.stapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yosa.stapi.domain.Starship;
import org.yosa.stapi.exceptions.NotFoundException;
import org.yosa.stapi.repositories.StarshipRepository;

import java.util.List;

@Service
public class StarshipService {
    @Autowired
    private StarshipRepository starshipRepository;

    public List<Starship> getStarships(){
        return starshipRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Starship getStarship(String id){
        return starshipRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Starship doesn't exist"));
    }

    public Starship create(Starship starship){
        return starshipRepository.save(starship);
    }

    public List<Starship> search(String title){
        return starshipRepository.findByTitleRegexOrderByIdDesc(title);
    }

    public void delete(String id){
        starshipRepository.delete(starshipRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Starship doesn't exist")));
    }

    public boolean isStarshipExist(String id){
        return starshipRepository.findById(id).isPresent();
    }
}
