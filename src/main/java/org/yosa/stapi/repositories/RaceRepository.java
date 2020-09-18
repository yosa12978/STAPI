package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yosa.stapi.domain.Race;

import java.util.List;

@Repository
public interface RaceRepository extends MongoRepository<Race, String> {
    List<Race> findByNameRegexOrderByIdDesc(String name);
    Race findByName(String name);
}
