package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yosa.stapi.domain.Starship;

@Repository
public interface StarshipRepository extends MongoRepository<Starship, String> {
}
