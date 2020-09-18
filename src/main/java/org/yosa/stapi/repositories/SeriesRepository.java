package org.yosa.stapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yosa.stapi.domain.Series;

import java.util.List;

@Repository
public interface SeriesRepository extends MongoRepository<Series, String> {
    List<Series> findByTitleRegexOrderByIdDesc(String title);
}
