package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yosa.stapi.domain.Series;

@Repository
public interface SeriesRepository extends MongoRepository<Series, String> {
}
