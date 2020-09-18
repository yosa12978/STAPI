package org.yosa.stapi.dtos;

import java.util.List;

public class CharacterDto {
    private String id;
    private String name;
    private RaceDto race;

    public CharacterDto() {
    }

    public CharacterDto(String id, String name, RaceDto race) {
        this.id = id;
        this.name = name;
        this.race = race;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RaceDto getRace() {
        return race;
    }

    public void setRace(RaceDto race) {
        this.race = race;
    }
}
