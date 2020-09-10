package org.yosa.stapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yosa.stapi.domain.Series;
import org.yosa.stapi.services.SeriesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {
    
    @Autowired
    private SeriesService seriesService;

    @GetMapping("")
    public List<Series> getAllSeries(){
        return seriesService.getAll();
    }

    @GetMapping("{id}")
    public Series getSeries(@PathVariable String id){
        return seriesService.getOne(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public ResponseEntity<Series> createSeries(@RequestBody Series series){
        return new ResponseEntity<>(seriesService.create(series), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable String id){
        if(!seriesService.isSeriesExist(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        seriesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
