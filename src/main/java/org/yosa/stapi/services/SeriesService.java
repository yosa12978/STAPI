package org.yosa.stapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yosa.stapi.domain.Series;
import org.yosa.stapi.repositories.SeriesRepository;

import java.util.List;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> getAll(){
        return seriesRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Series create(Series series){
        return seriesRepository.save(series);
    }

    public Series getOne(String id){
        return seriesRepository.findById(id).get();
    }

    public void delete(String id){
        seriesRepository.delete(seriesRepository.findById(id).get());
    }

    public boolean isSeriesExist(String id){
        return seriesRepository.findById(id).isPresent();
    }
}
