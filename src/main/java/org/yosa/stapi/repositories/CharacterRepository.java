package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yosa.stapi.domain.Character;

@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {
}
