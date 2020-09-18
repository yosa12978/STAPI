package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yosa.stapi.domain.Planet;

import java.util.List;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {
    List<Planet> findByTitleRegexOrderByIdDesc(String title);
}
