package org.yosa.stapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Planet {
    @Id
    private String id;
    private String title;
    private List<Race> races;

    public Planet() {
    }

    public Planet(String title) {
        this.title = title;
    }

    public Planet(String title, List<Race> races) {
        this.title = title;
        this.races = races;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}