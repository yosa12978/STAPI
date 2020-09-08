package org.yosa.stapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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
}
