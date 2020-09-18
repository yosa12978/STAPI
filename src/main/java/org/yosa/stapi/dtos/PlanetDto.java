package org.yosa.stapi.dtos;

import org.yosa.stapi.domain.Race;

import java.util.List;

public class PlanetDto {
    private String id;
    private String title;
    private List<RaceDto> races;

    public PlanetDto() {
    }

    public PlanetDto(String id, String title, List<RaceDto> races) {
        this.id = id;
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

    public List<RaceDto> getRaces() {
        return races;
    }

    public void setRaces(List<RaceDto> races) {
        this.races = races;
    }
}
