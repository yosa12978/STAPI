package org.yosa.stapi.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yosa.stapi.domain.Series;
import org.yosa.stapi.dtos.SeriesDto;
import org.yosa.stapi.services.SeriesService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;
    @Autowired
    private ModelMapper modelMapper;

    private static Logger logger = LoggerFactory.getLogger(SeriesController.class);

    @GetMapping("")
    public List<SeriesDto> getAllSeries(){
        List<Series> series = seriesService.getAll();
        logger.info("Return series");
        return modelMapper.map(series, new TypeToken<List<SeriesDto>>(){}.getType());
    }

    @GetMapping("{id}")
    public SeriesDto getSeries(@PathVariable String id){
        Series series = seriesService.getOne(id);
        logger.info("Return series with id " + id);
        return modelMapper.map(series, SeriesDto.class);
    }

    @GetMapping("search")
    public List<SeriesDto> searchSeries(@RequestParam("q") String query){
        List<Series> series = seriesService.search(query);
        logger.info("Search series with query = " + query);
        return modelMapper.map(series, new TypeToken<List<SeriesDto>>(){}.getType());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<SeriesDto> createSeries(@RequestBody Series series){
        Series createdSeries = seriesService.create(series);
        logger.info("Created series with id = " + createdSeries.getId());
        return new ResponseEntity<>(modelMapper.map(seriesService.create(series), SeriesDto.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable String id){
        if(!seriesService.isSeriesExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        seriesService.delete(id);
        logger.info("Deleted series with id = " + id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
