package org.yosa.stapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yosa.stapi.exceptions.NotFoundException;
import org.yosa.stapi.repositories.CharacterRepository;
import org.yosa.stapi.domain.Character;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> getAll(){
        return characterRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Character create(Character character){
        return characterRepository.save(character);
    }

    public Character getOne(String id){
        return characterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Character doesn't exist"));
    }

    public List<Character> search(String q){
        return characterRepository.findByNameRegexOrderByIdDesc(q);
    }

    public void delete(String id){
        characterRepository.delete(characterRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Character doesn't exist")));
    }

    public boolean isCharacterExist(String id){
        return characterRepository.findById(id).isPresent();
    }
}
