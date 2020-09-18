package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yosa.stapi.domain.Starship;

import java.util.List;

@Repository
public interface StarshipRepository extends MongoRepository<Starship, String> {
    List<Starship> findByTitleRegexOrderByIdDesc(String title);
}
